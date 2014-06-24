package com.home.maxwell.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.helper.ThreadLocalHelper;

public class ApctlInterceptor implements HandlerInterceptor, ApplicationContextAware{
			
	protected static ApplicationContext ctx;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}
	
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
			/*
			ThreadLocal threadlocal = new ThreadLocal();
			Map<String, Object> map = (Map<String, Object>)threadlocal.get();
			
			threadlocal.remove();
			if(map != null){
				map.clear();
				map = null;
			}	
			*/
		ThreadLocalHelper.release();
	}

	//將Http等Session訊息丟入ThreadLocal中，以供Model由ThreadLocal取得Http等Session，不會跟Http Adapter起耦合
	protected void buildThreadLocalTxData(HttpServletRequest request) {
		/*	
		ThreadLocal threadlocal = new ThreadLocal();
		Map<String, Object> map = new HashMap<String, Object>();
		
		//將Request放入ThreadLocal
		map.put(ConstantKey.REQUEST_OBJ_ATTR, request);
		
		//從ServletContext取得environment
		Object obj = request.getSession().getServletContext().getAttribute(ConstantKey.ENV_RUNTIME_ATTR);
		//將environment放入ThreadLocal
		map.put(ConstantKey.ENV_RUNTIME_ATTR, obj);
			
		//將ApplicationContext放入ThreadLocal
		map.put(ConstantKey.SPRING_CONTEXT_ATTR, ApctlInterceptor.ctx);
		
		ApplicationContext ctx  = (ApplicationContext)map.get(ConstantKey.SPRING_CONTEXT_ATTR);
		System.out.println(ctx.toString());
		
		threadlocal.set(map);	
		*/
		ThreadLocalHelper.setApplicationContext(ApctlInterceptor.ctx);
		ThreadLocalHelper.setHttpRequest(request);
		Object obj = request.getSession().getServletContext().getAttribute(ConstantKey.ENV_RUNTIME_ATTR);
		ThreadLocalHelper.setEnvRuntime(obj);
		
	}
	
}
