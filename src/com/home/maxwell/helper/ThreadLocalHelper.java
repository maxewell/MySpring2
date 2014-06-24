package com.home.maxwell.helper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpRequest;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.env.EnvirContext;
import com.home.maxwell.interceptor.ApctlInterceptor;

public class ThreadLocalHelper {
	protected static Logger logger = LoggerFactory.getLogger(ThreadLocalHelper.class);
	
	//protected static final String ENV_RUNTIME_ATTR ="___ENV__RUNTIME";
	protected static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>(){
		@Override
		protected Map<String, Object> initialValue() {
			return null;
		}
	};
	
	private ThreadLocalHelper(){}
	
	public static InputStream getResourceAsStream(String name){
		/*
		Map<String, Object> map = (Map<String, Object>)threadLocal.get();
		EnvirContext envCtx = (EnvirContext)map.get(ConstantKey.ENV_RUNTIME_ATTR);
		
		InputStream is = envCtx.getResourceAsStream(name);
		
		return is;
		*/
		return null;
	}
	
	public static Set getResourcePaths(String name){
		return null;
	}
	
	public static Object getBean(String name){
		Map<String, Object> map = (Map<String, Object>)threadLocal.get();
		ApplicationContext ctx = (ApplicationContext)map.get(ConstantKey.SPRING_CONTEXT_ATTR);
		
		Object is = ctx.getBean(name);
		
		HttpServletRequest req = (HttpServletRequest)map.get(ConstantKey.REQUEST_OBJ_ATTR);
		logger.info("ThreadLocal req:" + req.toString());
		
		return is;
	}

	protected static Map<String, Object> getLocalMap(){
		Map<String, Object> map = (Map<String, Object>)threadLocal.get();
		if (map == null){
			map = new HashMap<String, Object>();
		}
		threadLocal.set(map);
		return map;
	}
	
	public static void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		Map<String, Object> map = getLocalMap();
		map.put(ConstantKey.SPRING_CONTEXT_ATTR, ctx);
				
	}

	public static void setHttpRequest(HttpServletRequest request) {
		Map<String, Object> map = getLocalMap();
		map.put(ConstantKey.REQUEST_OBJ_ATTR, request);
		
	}

	public static void setEnvRuntime(Object obj) {
		Map<String, Object> map = getLocalMap();
		map.put(ConstantKey.ENV_RUNTIME_ATTR, obj);
		
	}

	public static void release() {
		threadLocal.remove();
	}
	
	
}
