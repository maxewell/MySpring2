package com.home.maxwell.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MyMultiActionController extends MultiActionController{
	protected static final String PREV_VIEW_NAME_ATTR = "___PRE__VIEW";
	protected static final String REQUEST_ID_ATTR = "___REQUEST__ID";
	
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		//將Http等Session訊息丟入ThreadLocal中，以供Model(非Controller)由ThreadLocal取得Http等Session，不會跟Http Adapter起耦合
		buildThreadLocalTxData(request);
		
		ModelAndView mv = super.handleRequestInternal(request, response);
		
		//清除ThreadLocal中Http等Session資料
		releaseThreadLocalTxData();
		
		HttpSession session = request.getSession(false);
		if (mv != null){
			String returnview = mv.getViewName();
			if (session != null && returnview != null){
				session.setAttribute(PREV_VIEW_NAME_ATTR, returnview);
			}
		}
		
		return mv;
	}
	
	//清除ThreadLocal中Http等Session資料
	protected void releaseThreadLocalTxData() {
		ThreadLocal threadlocal = new ThreadLocal();
		Map<String, Object> map = (Map<String, Object>)threadlocal.get();
		
		threadlocal.remove();
		if(map != null){
			map.clear();
			map = null;
		}	
	}

	//將Http等Session訊息丟入ThreadLocal中，以供Model由ThreadLocal取得Http等Session，不會跟Http Adapter起耦合
	protected void buildThreadLocalTxData(HttpServletRequest request) {
		ThreadLocal threadlocal = new ThreadLocal();
		Map<String, Object> map = new HashMap<String, Object>();
		threadlocal.set(map);
		map.put(REQUEST_ID_ATTR, getRequestId(request));
	}

	private String getRequestId(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView hanldeBindException(HttpServletRequest request, HttpServletResponse response, ServletRequestBindingException reqbindingException) {
		BindException be1 = (BindException)reqbindingException.getRootCause();
		Map model = be1.getModel();
		
		HttpSession session = request.getSession(false);
		String viewname = (String)session.getAttribute(PREV_VIEW_NAME_ATTR);

		//TODO: if viewname is null when invoke directly from index.jsp in webroot
		
		return new ModelAndView(viewname, model);
	}	
}
