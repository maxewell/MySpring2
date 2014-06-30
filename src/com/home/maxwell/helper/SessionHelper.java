package com.home.maxwell.helper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.service.AsyncStatus;

public class SessionHelper {

	public static void addStatusList(HttpSession session, AsyncStatus status) {
		List<AsyncStatus> statusList = (List<AsyncStatus>) session.getAttribute(ConstantKey.ASYNC_STATUS_LIST);
		if (statusList == null){
			statusList = new ArrayList<AsyncStatus>();
			session.setAttribute(ConstantKey.ASYNC_STATUS_LIST, statusList);
		}
		statusList.add(status);
	}

	public static AsyncStatus getAsyncStatus(HttpSession session, String statusId) {
		List<AsyncStatus> statusList = (List<AsyncStatus>) session.getAttribute(ConstantKey.ASYNC_STATUS_LIST);
		if (statusList != null){
			for (AsyncStatus status : statusList){
				if (statusId.equals(status.getTxId())){
					if (status.isDone()){
						statusList.remove(status);
					}
					return status; 
				}
			}
		}
		return null;
	}

	
}
