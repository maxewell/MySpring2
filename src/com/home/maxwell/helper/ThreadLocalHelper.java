package com.home.maxwell.helper;

import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import com.home.maxwell.env.EnvirContext;

public class ThreadLocalHelper {
	protected static final String ENV_RUNTIME_ATTR ="___ENV__RUNTIME";
	
	public static InputStream getResourceAsStream(String name){
		ThreadLocal tl = new ThreadLocal();
		Map<String, Object> map = (Map<String, Object>)tl.get();
		EnvirContext envCtx = (EnvirContext)map.get(ENV_RUNTIME_ATTR);
		
		InputStream is = envCtx.getResourceAsStream(name);
		
		return is;
	}
	
	public static Set getResourcePaths(String name){
		return null;
	}
	
	public static Object getBean(String name){
		//TODO: 
		return null;
	}
}
