package com.home.maxwell.codeview;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

public class MyUserRoleAuthorizationInterceptor extends UserRoleAuthorizationInterceptor{

	public void testMethod(HttpServletRequest req){
		req.isUserInRole("");
	}
}
