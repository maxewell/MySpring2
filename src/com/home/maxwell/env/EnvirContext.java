package com.home.maxwell.env;

import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class EnvirContext implements ApplicationContextAware{
	
	protected EnvironType envType = EnvironType.ENVIR_DE;
	protected ApplicationContext appCtx;
	
	public EnvironType getEnvType() {
		return envType;
	}

	public void setEnvType(EnvironType envType) {
		this.envType = envType;
	}

	public void setApplicationContext(ApplicationContext ctx)throws BeansException {
		this.appCtx = ctx;
	}

	public Set getResourcePaths(String resstr) {
		Set rs = null;
		
		if (resstr != null && this.appCtx != null){
			if (this.appCtx instanceof WebApplicationContext){
				WebApplicationContext webctx = (WebApplicationContext) appCtx;
				ServletContext srvctx = webctx.getServletContext();
	            rs = srvctx.getResourcePaths(resstr);
	       }
		}
		
		
		return rs;
	}
	
	public InputStream getResourceAsStream(String resstr) {
		InputStream rs = null;
		if (resstr != null && this.appCtx != null){
			if (appCtx instanceof WebApplicationContext){
				WebApplicationContext webctx = (WebApplicationContext) appCtx;
				ServletContext srvctx = webctx.getServletContext();
	            rs = srvctx.getResourceAsStream(resstr);
	       }
		}
		
		return rs;
	}
	
	
}
