package com.home.maxwell.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.home.maxwell.domain.InternalError;
import com.home.maxwell.exception.ApctlException;

public class ApctlController extends MultiActionController{
	protected static final String PREV_VIEW_NAME_ATTR = "___PRE__VIEW";
	//protected static final String REQUEST_OBJ_ATTR = "___REQUEST__OBJ";
	//protected static final String ENV_RUNTIME_ATTR ="___ENV__RUNTIME";
	
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		//將Http等Session訊息丟入ThreadLocal中，以供Model(非Controller)由ThreadLocal取得Http等Session，不會跟Http Adapter起耦合
		//buildThreadLocalTxData(request);
		
		ModelAndView mv = null;
		
		//所有Ap中,若有異常，無法執行下去，就Throw出來，apctl來處理
		//處理動作，回到前一頁，顯示錯誤訊息
		try {
			mv = super.handleRequestInternal(request, response);
			
		} catch (ApctlException t){
			BindException bex = new BindException(t.getCommand(), t.getCommandName());
			ObjectError err = new ObjectError(t.getCommandName(), new String[]{t.getApctlErrCodeEnum().toString()}, 
					(t.getParamList() != null) ? t.getParamList().toArray() : null, t.getMessage());
			bex.addError(err);
			
			request.setAttribute("APCTL_STATUS_MSG", "服務處理錯誤");
			
			HttpSession session = request.getSession(false);
			session.setAttribute(PREV_VIEW_NAME_ATTR, t.getViewName());
			
			return new ModelAndView(t.getViewName(), bex.getModel());
			
		} catch (Throwable t){
			//TODO: 
		}
		
		//清除ThreadLocal中Http等Session資料
		//releaseThreadLocalTxData();
		
		HttpSession session = request.getSession(false);
		if (mv != null){
			String returnview = mv.getViewName();
			if (session != null && returnview != null){
				session.setAttribute(PREV_VIEW_NAME_ATTR, returnview);
			}
		}
		
		return mv;
	}
	
	/*
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
		//從ServletContext取得environment
		Object obj = request.getSession().getServletContext().getAttribute(ENV_RUNTIME_ATTR);
		ThreadLocal threadlocal = new ThreadLocal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(REQUEST_OBJ_ATTR, request);
		//將environment放入ThreadLocal
		map.put(ENV_RUNTIME_ATTR, obj);
		
		threadlocal.set(map);	
	}
	*/
	
	//當control處理有問題時，可呼叫此function處理
	public ModelAndView throwResponse(HttpServletRequest request, String viewName, String commandName, Object domain){
		BindException bex = new BindException(domain, commandName);
		ObjectError err = new ObjectError(commandName, new String[]{"internalError.ErrorMsg"}, null, "Default Error Message");
		bex.addError(err);
		
		request.setAttribute("APCTL_STATUS_MSG", "服務處理錯誤");
		
		HttpSession session = request.getSession(false);
		session.setAttribute(PREV_VIEW_NAME_ATTR, viewName);
		
		return new ModelAndView(viewName, bex.getModel());
	}
	
	
	public ModelAndView handleBindException(HttpServletRequest request, HttpServletResponse response, ServletRequestBindingException reqbindingException) {
		BindException be1 = (BindException)reqbindingException.getRootCause();
				
		Map model = be1.getModel();
		request.setAttribute("APCTL_STATUS_MSG", "輸入資料轉換處理錯誤");
		
		HttpSession session = request.getSession(false);
		String viewname = (String)session.getAttribute(PREV_VIEW_NAME_ATTR);

		//TODO: if viewname is null when invoke directly from index.jsp in webroot
		
		return new ModelAndView(viewname, model);
		
	}	
}
