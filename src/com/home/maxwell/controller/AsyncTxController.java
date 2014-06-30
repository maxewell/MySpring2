package com.home.maxwell.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.domain.FtpJob;
import com.home.maxwell.domain.TxStatusImpl;
import com.home.maxwell.domain.UserInfo;
import com.home.maxwell.helper.SessionHelper;
import com.home.maxwell.helper.ThreadLocalHelper;
import com.home.maxwell.model.MockFacade;
import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxCallable;
import com.home.maxwell.service.TxStatus;

public class AsyncTxController extends ApctlController{
	protected static Logger logger = LoggerFactory.getLogger(AsyncTxController.class);
	protected String name;
	protected AsyncService asyncService;
	protected MockFacade mockFacade;
	
	protected String showName;
	protected String resultName;
	protected String resultListName;
	protected String statusResult;
	protected String statusRefresh;

	public ModelAndView onShowForm(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletRequestBindingException{
		return new ModelAndView(this.showName);
	}
	
	//沒有寫好的Runnable
	//1. new一個anonymous Runnable物件,將要做的工作與data至於其中run method()
	//2. 呼叫ansyncService.asyncRun(name, r)
	public ModelAndView onRunAsyncTx(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletRequestBindingException{
		final String data = ServletRequestUtils.getRequiredStringParameter(request, "data");
		
		//假設userId可由Session.userId取得
		//UserInfo user = (UserInfo)WebUtils.getSessionAttribute(request, "userId");
		//String userId = user.getId();
		String userId = "A123456789";
		
		Runnable r = new Runnable(){
			public void run(){
				//try {
					//Exception 還是要Throw出來，由asyncService那邊去catch,
				    //可以?
				    //結論: 在此不用try-catch,讓它throw 出去
				    //理由: 在asyncService中會用一個ITxCallable物件instance將此runnable包裝起來wrap
				    //     此ITxCallable的呼叫過程有try-catch機制
				
					mockFacade.doLongTimeMockSomething(data);
				/*
				}catch(Exception e){					
				}finally{					
				}
				*/
			};
		};
		
		AsyncStatus status = null;
		status = asyncService.asyncRun(name, r, userId);
		
		session.setAttribute("___ASYNC__SERVICE_STATUS", status);
		SessionHelper.addStatusList(session, status);
		
		return new ModelAndView(this.resultName);
	}
	
	//使用已寫好的Runnable
	//已寫好的Async Service用法
	//1. 利用ThreadLocalHelper.getBean()取得Service instance(此instance為prototype,非singleton)
	//2. 利用setRunData(),帶入Service須用的參數
	//3. 呼叫此asyncService的asyncRun(name, r)
	public ModelAndView onRunAsyncTxService(HttpServletRequest request, HttpServletResponse response, HttpSession session, FtpJob job) throws ServletRequestBindingException{
		
		//假設userId可由Session.userId取得
		//UserInfo user = (UserInfo)WebUtils.getSessionAttribute(request, "userId");
		//String userId = user.getId();
		String userId = "A123456789";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ConstantKey.FTP_LOCAL_FILE, "F:/MyFtp.zip");
		map.put(ConstantKey.FTP_REMOTE_FILE, "FtpTest.zip");
		map.put(ConstantKey.FTP_RUN_METHOD, "get");
		map.put(ConstantKey.FTP_TYPE_IS_ASCII, Boolean.FALSE);
		
		//Sync與Async的ftp如何重用配置
		//Sync的ftp impl就是一般EdpFtpServiceImpl
		//Async的ftp impl就是
		/*
		   Runnable(){
		      public void run(){
		        //remoteDir, remoteFileName,...等資料如何傳入
		      	EdpFtpService.getFile(String remoteDir, String remoteFileName, String localFileName, boolean isAscii);
		      }
		   }
		 */
		
		//FtpRunnableImpl裡面內有EdtpFtpServiceImpl(singleton)
		//但FtpRunnableImpl不能是Singleton
		//所以用Spring getBean()
		ITxCallable r = (ITxCallable)ThreadLocalHelper.getBean("asyncFtpService");
		
		//WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		//ITxCallable r = (ITxCallable)ctx.getBean("asyncFtpService");
		
		r.setRunData(map);
		
		AsyncStatus status = null;
		status = asyncService.asyncRun(name, r, userId);
		
		session.setAttribute("___ASYNC__SERVICE_STATUS", status);
		SessionHelper.addStatusList(session, status);
				
		return new ModelAndView(this.resultName);
	}
	
	//wish to query the 某一TxStatus進度
	/*
	 * AysncStatus: 某一AsyncTx回應的status
	 */
	public ModelAndView onQueryTxProgress(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		//假設userId可由Session.userId取得
		//UserInfo user = (UserInfo)WebUtils.getSessionAttribute(request, "userId");
		//String userId = user.getId();
		String userId = "A123456789";
				
		String statusId = ServletRequestUtils.getRequiredStringParameter(request, "asyncStatusId");
																				   
		AsyncStatus status = SessionHelper.getAsyncStatus(session, statusId);
		TxStatus astatus;
		
		if (status == null){
			astatus = asyncService.queryTxStatus(userId, this.name, statusId);
		}else{
			astatus = status;
		}
		
		if (request.getHeader("Ajax") != null){
			return new ModelAndView(this.statusRefresh, "__ASYNC_STATUS_OBJ", astatus);
		}else{
			return new ModelAndView(this.statusResult, "__ASYNC_STATUS_OBJ", astatus);
		}	
		//ITxRunnable內有status reference,會直接更新status的值,不需再去作其他動作
		//logger.info("RS status:" + status.getTxResult(2000));
		//session.removeAttribute("___ASYNC__SERVICE_STATUS");
		
		//return new ModelAndView(this.resultName);
	}
	
	public ModelAndView onQuerySessionTxProgress(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		AsyncStatus status = (AsyncStatus)session.getAttribute("___ASYNC__SERVICE_STATUS");
				
		//ITxRunnable內有status reference,會直接更新status的值,不需再去作其他動作
		logger.info("RS status:" + status.getTxResult(2000));
		//session.removeAttribute("___ASYNC__SERVICE_STATUS");
		
		return new ModelAndView(this.resultName);
	}
	
	//wish to query 某人執行此AsyncTx的所以執行結果
	/*
	 * UserInfo: 識別某一人的資訊
	 */
	public ModelAndView onQueryTxStatusList(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		//假設userId可由Session.userId取得
		//UserInfo user = (UserInfo)WebUtils.getSessionAttribute(request, "userId");
		//String userId = user.getId();
		String userId = "A123456789";
				
		//使用user與此交易名去查詢此user執行此交易過的歷史記錄
		List<TxStatus> list = asyncService.queryTxStatusList(userId, name);
		
		return new ModelAndView(this.resultListName, "___ASYNC__TX_LIST", list);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public AsyncService getAsyncService() {
		return asyncService;
	}

	public void setAsyncService(AsyncService asyncService) {
		this.asyncService = asyncService;
	}

	public MockFacade getMockFacade() {
		return mockFacade;
	}

	public void setMockFacade(MockFacade mockFacade) {
		this.mockFacade = mockFacade;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	
	public String getResultListName() {
		return resultListName;
	}

	public void setResultListName(String resultListName) {
		this.resultListName = resultListName;
	}

	public String getStatusResult() {
		return statusResult;
	}

	public void setStatusResult(String statusResult) {
		this.statusResult = statusResult;
	}
	
	public String getStatusRefresh() {
		return statusRefresh;
	}

	public void setStatusRefresh(String statusRefresh) {
		this.statusRefresh = statusRefresh;
	}

}
