package com.home.maxwell.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.home.maxwell.service.TxStatus;

public class AsyncStatusView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map model, HttpServletRequest req, HttpServletResponse resp)	throws Exception {
		TxStatus status = (TxStatus)model.get("__ASYNC_STATUS_OBJ");
		
		int progress = status.getProgress();
		
		StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        
        xml.append("<PROGRESS>");
        xml.append(progress);
        xml.append("</PROGRESS>");
        
        String xmlstr = xml.toString();
        
        logger.info(xmlstr);
        
        setContentType("text/xml");
        
        resp.setContentType(getContentType());
        
        // tell browser not to cache response
        resp.setHeader("Cache-Control", "no-cache");
        resp.getWriter().write(xmlstr);
        resp.flushBuffer();
		
	}
}
