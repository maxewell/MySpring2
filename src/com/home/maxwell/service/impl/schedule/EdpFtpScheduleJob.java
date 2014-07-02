package com.home.maxwell.service.impl.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.helper.ThreadLocalHelper;
import com.home.maxwell.service.FtpService;

public abstract class EdpFtpScheduleJob extends BaseQuartzJobBean{
	protected FtpService ftpService;
	
	protected void preExecute(JobExecutionContext context) throws JobExecutionException {
		ftpService = (FtpService)ThreadLocalHelper.getBean("ftpService");
		if (ftpService == null){
			throw new JobExecutionException("Component is not found.");
		}
	}
	
	public void doSchedule(JobExecutionContext context) throws JobExecutionException{
		String method = (String)this.dataMap.get(ConstantKey.FTP_RUN_METHOD);
		String localFile = (String)this.dataMap.get(ConstantKey.FTP_LOCAL_FILE);
		String remoteDir = (String)this.dataMap.get(ConstantKey.FTP_REMOTE_DIR);
		String remoteFile = (String)this.dataMap.get(ConstantKey.FTP_REMOTE_FILE);
		Boolean isAscii = (Boolean)this.dataMap.get(ConstantKey.FTP_TYPE_IS_ASCII);
		
		try {
			if (ConstantKey.FTP_RUN_METHOD_GET.equals(method)){
				ftpService.getFile(remoteDir, remoteFile, localFile, isAscii);
			}else if (ConstantKey.FTP_RUN_METHOD_GET.equals(method)){
				ftpService.sendFile(remoteDir, remoteFile, localFile, isAscii);
			}else{
				throw new Exception("is not GET or PUT method");
			}
		}catch(Throwable e){
			throw new JobExecutionException(e);
		}
	}
	
	
}
