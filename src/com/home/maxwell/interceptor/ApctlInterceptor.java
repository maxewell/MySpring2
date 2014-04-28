package com.home.maxwell.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ApctlInterceptor implements HandlerInterceptor{
	protected static final String ENV_RUNTIME_ATTR ="___ENV__RUNTIME";
	protected static final String REQUEST_OBJ_ATTR = "___REQUEST__OBJ";
	
	public void afterCompletion(HttpServletRequest request,	HttpServletResponse response, Object handler, Exception ex)	throws Exception {
		//清除ThreadLocal中Http等Session資料
		releaseThreadLocalTxData();
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//將Http等Session訊息丟入ThreadLocal中，以供Model(非Controller)由ThreadLocal取得Http等Session，不會跟Http Adapter起耦合
		buildThreadLocalTxData(request);
		
		//************ Be careful, it must return true if want to going down
		return true;
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
		
		//將Request放入ThreadLocal
		map.put(REQUEST_OBJ_ATTR, request);
		
		//從ServletContext取得environment
		Object obj = request.getSession().getServletContext().getAttribute(ENV_RUNTIME_ATTR);
		//將environment放入ThreadLocal
		map.put(ENV_RUNTIME_ATTR, obj);
			
		threadlocal.set(map);	
	}
	
}
