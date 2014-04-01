package com.home.maxwell.view.menu.type2;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.view.menu.AbstractMenuItem;
import com.home.maxwell.view.menu.MenuItem;

/*
 * type2:
 * <li><a><img><span>xxxx</span><div></div></a>
 * xxx (if has submenu)
 * </li>
 * 
 * <div>: class use to display rightarrow or downarrow
 *
 */
public class BaseMenuItem extends AbstractMenuItem{
	
	public BaseMenuItem(){
	}
	
	public BaseMenuItem(String id, String name) {
		super(id, name);
	}
	
	public BaseMenuItem(String name) {
		super(name);
	}

	@Override
	public String createBaseMenu() {
		StringBuffer sbf = new StringBuffer();
		
		String tmp = createLiBeginTag();
		sbf.append(tmp);
		
		tmp = createAnch();
		sbf.append(tmp);
		
		return sbf.toString();
	}
	
	protected String createLiBeginTag() {
		if (this.classz == null){
			return LI_START_TAG_STR;
		}else{
			return "<li class=\"" + this.classz + "\">";
		}
	}
	
	protected String createAnch() {
		StringBuffer sbf = new StringBuffer();
		
		String tmp = createAnchBeginTag();
		sbf.append(tmp);
		
		tmp = this.createImg();
		sbf.append(tmp);
		
		tmp = createSpan();
		sbf.append(tmp);
		
		if (this.hasSubMenu()){
			tmp = createDiv();
			sbf.append(tmp);
		}
		
		sbf.append(ANCHOR_END_TAG_STR);
		return sbf.toString();
	}
	
	protected String createDiv() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("<div class=\"rightarrow\"></div>");
		return sbf.toString();
	}

	protected String createHasSubMenuDiv() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String createSpan() {
		StringBuffer sbf = new StringBuffer();
		
		sbf.append(SPAN_START_TAG_STR);
		sbf.append(this.name);
		sbf.append(SPAN_END_TAG_STR);
		
		return sbf.toString();
	}
	protected String createAnchBeginTag() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("<a href=\"");
		
		if (this.url != null){
			sbf.append(this.url);
		}else{
			sbf.append(ConstantKey.BASE_SHARP_STR);
		}
		sbf.append("\">");
		
		return sbf.toString();
	}
	@Override
	public String createSubMenus() {
		StringBuffer sbf = new StringBuffer();
		
		String tmp = createUlBeginTag();
		sbf.append(tmp);
		
		for(MenuItem item : this.subMenuList){
			tmp = item.getHtmlMenu();
			sbf.append(tmp);
		}
		
		sbf.append(UL_END_TAG_STR);
		
		return sbf.toString();
		
	}

	protected String createUlBeginTag() {
		return UL_START_TAG_STR;
	}
}
