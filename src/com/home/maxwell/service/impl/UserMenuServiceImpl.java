package com.home.maxwell.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.util.Assert;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.service.UserMenuService;

public class UserMenuServiceImpl implements UserMenuService{

	public String getUserMenu(HttpSession session) {
		Assert.notNull(session, "Session can not be null");
		return (String)session.getAttribute(ConstantKey.ATTR_SESSION_USER_MENU);
	}

	public void setUserMenu(String menu, HttpSession session) {
		Assert.notNull(session, "Session can not be null");
		session.setAttribute(ConstantKey.ATTR_SESSION_USER_MENU, menu);
	}

}
