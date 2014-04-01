package com.home.maxwell.view.menu.type1;

import com.home.maxwell.view.menu.AbstractMenuItem;

public class BaseTopMenuItem extends BaseMenuItem{

	public BaseTopMenuItem(String name) {
		super(name);
	}
	
	/*
	protected String createHasSubMenuItem() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("<div class=\"downarrow\">");
		String tmp = createBaseMenuItem();
		sbf.append(tmp);
		sbf.append("</div>");
		
		return sbf.toString();
	}
	*/
	
	protected String createUlBeginTag() {
		return "<ul class=\"first\">"; 
	}
	
	protected String createHasSubMenuSpan() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("<span class=\"downarrow\">");
		sbf.append(this.name);
		sbf.append(SPAN_END_TAG_STR);
		
		return sbf.toString();
	}
}
