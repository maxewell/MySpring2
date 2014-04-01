package com.home.maxwell.view.menu;

import java.util.List;
import java.util.Map;

public interface MenuItem {
	public void setId(String id);
	public String getId();
	public void setName(String name);
	public void setIcon(String icon);
	public void setUrl(String url);
	public void setClass(String cls);
	public void addSubMenuItem(MenuItem item);
	public Map<String, MenuItem> getSubMenuMap();
	public String getHtmlMenu();
	public void setSubMenuList(List<MenuItem> list);
}
