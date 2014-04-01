package com.home.maxwell.service;

import javax.servlet.http.HttpSession;

public interface UserMenuService {
	public String getUserMenu(HttpSession session);
	public void setUserMenu(String menu, HttpSession session);
}
