package com.home.maxwell.view.menu.type2;

public class BaseTopMenuItem extends BaseMenuItem{
	public BaseTopMenuItem(String name) {
		super(name);
	}
	protected String createUlBeginTag() {
		return "<ul class=\"first\">"; 
	}
	protected String createDiv() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("<div class=\"downarrow\"></div>");
		return sbf.toString();
	}
}
