package com.home.maxwell.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.domain.FtpJob;
import com.home.maxwell.domain.UserInfo;
import com.home.maxwell.helper.ThreadLocalHelper;
import com.home.maxwell.model.MockFacade;
import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxRunnable;

public class AsyncTxController extends ApctlController{
	protected String name;
	protected AsyncService asyncService;
	protected MockFacade mockFacade;

	//沒有寫好的Runnable
	public ModelAndView runAsyncTx(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletRequestBindingException{
		final String data = ServletRequestUtils.getRequiredStringParameter(request, "data");
		
		Runnable r = new Runnable(){
			public void run(){
				try {
					mockFacade.doMockNothing(data);
				}catch(Exception e){
					
				}finally{
					
				}
			};
		};
		
		AsyncStatus status = null;
		status = asyncService.asyncRun(name, r);
		session.setAttribute("XXXXX", status);
		
		return null;
	}
	
	//使用已寫好的Runnable
	public ModelAndView runAsyncTxService(HttpServletRequest request, HttpServletResponse response, HttpSession session, FtpJob ftpJob) throws ServletRequestBindingException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("FTP_SERVICE_SRC", ftpJob.getSrcFile());
		map.put("FTP_SERVICE_DEST", ftpJob.getDestFile());
		
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
		ITxRunnable r = (ITxRunnable)ThreadLocalHelper.getBean("XXXX");
		r.setRunData(map);
		
		AsyncStatus status = null;
		status = asyncService.asyncRun(name, r);
		session.setAttribute("XXXXX", status);
		
		return null;
	}
	
	//wish to query the 某一TxStatus進度
	/*
	 * AysncStatus: 某一AsyncTx回應的status
	 */
	public ModelAndView queryTxProgress(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		AsyncStatus status = (AsyncStatus)session.getAttribute("XXXX");
		//ITxRunnable內有status reference,會直接更新status的值
		
		return null;
	}
	
	//wish to query 某人執行此AsyncTx的所以執行結果
	/*
	 * UserInfo: 識別某一人的資訊
	 */
	public ModelAndView queryAsyncTxStatusList(HttpServletRequest request, HttpServletResponse response, HttpSession session, UserInfo user){
		List<AsyncStatus> list = asyncService.queryAsyncTxStatusList(user, name);
		return null;
	}
	
	
}
