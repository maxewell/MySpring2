package com.home.maxwell.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.domain.FtpJob;
import com.home.maxwell.helper.ThreadLocalHelper;
import com.home.maxwell.model.MockFacade;
import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxRunnable;

public class AsyncTxController extends ApctlController{
	protected AsyncService asyncService;
	protected MockFacade mockFacade;

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
		status = asyncService.asyncRun(r);
		
		return null;
	}
	
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
		
		//裡面FtpRunnableImpl內有EdtpFtpServiceImpl(singleton)
		//但FtpRunnableImpl不能是Singleton
		//所以用Spring getBean()
		ITxRunnable r = (ITxRunnable)ThreadLocalHelper.getBean("");
		r.setRunData(map);
		
		AsyncStatus status = null;
		status = asyncService.asyncRun(r);
		
		return null;
	}
	
	
	
}
