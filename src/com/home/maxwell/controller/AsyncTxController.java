package com.home.maxwell.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.domain.FtpJob;
import com.home.maxwell.domain.UserInfo;
import com.home.maxwell.helper.ThreadLocalHelper;
import com.home.maxwell.model.MockFacade;
import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxCallable;

public class AsyncTxController extends ApctlController{
	protected static Logger logger = LoggerFactory.getLogger(AsyncTxController.class);
	protected String name;
	protected AsyncService asyncService;
	protected MockFacade mockFacade;

	//沒有寫好的Runnable
	public ModelAndView onRunAsyncTx(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletRequestBindingException{
		final String data = ServletRequestUtils.getRequiredStringParameter(request, "data");
		
		Runnable r = new Runnable(){
			public void run(){
				//try {
					//Exception 還是要Throw出來，由asyncService那邊去catch,
				    //可以?
					mockFacade.doMockNothing(data);
				/*
				}catch(Exception e){					
				}finally{					
				}
				*/
			};
		};
		
		AsyncStatus status = null;
		status = asyncService.asyncRun(name, r);
		session.setAttribute("___ASYNC__SERVICE_STATUS", status);
		
		//try to get the result or forward to query action
		try {
			int rs = status.getResult(2000);
			logger.info("RS:" + rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//使用已寫好的Runnable
	public ModelAndView onRunAsyncTxService(HttpServletRequest request, HttpServletResponse response, HttpSession session, FtpJob ftpJob) throws ServletRequestBindingException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ConstantKey.FTP_LOCAL_FILE, "MyFtp.zip");
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
		//ITxCallable r = (ITxCallable)ThreadLocalHelper.getBean("asyncFtpService");
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		ITxCallable r = (ITxCallable)ctx.getBean("asyncFtpService");
		r.setRunData(map);
		
		AsyncStatus status = null;
		status = asyncService.asyncRun(name, r);
		session.setAttribute("___ASYNC__SERVICE_STATUS", status);

				
		return null;
	}
	
	//wish to query the 某一TxStatus進度
	/*
	 * AysncStatus: 某一AsyncTx回應的status
	 */
public ModelAndView onQueryTxProgress(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		AsyncStatus status = (AsyncStatus)session.getAttribute("___ASYNC__SERVICE_STATUS");
		//ITxRunnable內有status reference,會直接更新status的值,不需再去作其他動作
		logger.info("RS status:" + status.getResult(2000));
		session.removeAttribute("___ASYNC__SERVICE_STATUS");
		
		return null;
	}
	
	//wish to query 某人執行此AsyncTx的所以執行結果
	/*
	 * UserInfo: 識別某一人的資訊
	 */
	public ModelAndView queryAsyncTxStatusList(HttpServletRequest request, HttpServletResponse response, HttpSession session, UserInfo user){
		//使用user與此交易名去查詢此user執行此交易過的歷史記錄
		List<AsyncStatus> list = asyncService.queryAsyncTxStatusList(user, name);
		return null;
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

}
