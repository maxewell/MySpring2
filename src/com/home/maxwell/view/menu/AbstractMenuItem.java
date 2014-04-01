package com.home.maxwell.view.menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.home.maxwell.ConstantKey;

public abstract class AbstractMenuItem implements MenuItem{
	protected static String DIV_END_TAG_STR = "</div>";
	protected static String UL_START_TAG_STR = "<ul>";
	protected static String UL_END_TAG_STR = "</ul>";
	protected static String LI_START_TAG_STR = "<li>";
	protected static String LI_END_TAG_STR = "</li>";
	protected static String ANCHOR_END_TAG_STR = "</a>";
	protected static String SPAN_START_TAG_STR = "<span>";
	protected static String SPAN_END_TAG_STR = "</span>";
	
	protected String name;
	protected String id;
	protected String url;
	protected String icon;
	protected String classz;
	protected Map<String, MenuItem> subMenuMap;
	protected List<MenuItem> subMenuList;
	
	public AbstractMenuItem(){
	}
	
	public AbstractMenuItem(String name){
		this.name = name;
	}
	
	public AbstractMenuItem(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String getHtmlMenu(){
		String basemenu, submenu;
		StringBuffer sbf = new StringBuffer();
				
		basemenu = createBaseMenu();
		sbf.append(basemenu);
		
		if (hasSubMenu()){
			submenu = createSubMenus();
			sbf.append(submenu);
		}	
		
		sbf.append(LI_END_TAG_STR);
		return sbf.toString();
	}
	
	protected boolean hasSubMenu(){
		if (subMenuList != null && subMenuList.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public abstract String createBaseMenu();
	public abstract String createSubMenus();
	
	protected String createImg() {
		return "<img src=\"" + icon + "\" />";
	}
	
	/*
	private String createLiTag() {
		if (classz != null){
			//<li class="top">
			return "<li class=\"" + classz + "\">";
		}else{
			if (hasSubMenu()){
				//<li class="sub">
				return "<li class=\"sub\">";
			}else{
				//<li>
				return LI_START_TAG_STR;
			}
		}
	}
*/
	
	/*
	private String createSubMenus() {
		StringBuffer sbf = new StringBuffer();
		//sbf.append(UL_START_TAG_STR);
		String ul = createUlTag();
		sbf.append(ul);
		
		for(MenuItem item : subMenuList){
			String tmp = item.getHtmlMenu();
			sbf.append(tmp);
		}
		
		sbf.append(UL_END_TAG_STR);
		
		return sbf.toString();
	}
	
	protected String createUlTag() {
	
		return UL_START_TAG_STR;
	}
	
	
	private String createBaseMenu() {
		String rs = null;
		
		if (hasSubMenu()){
			rs = createHasSubMenuItem();
		}else{
			rs = createBaseMenuItem();
		}
		
		return rs;
	}
	
	
	protected String createHasSubMenuItem() {
		return createBaseMenuItem();
	}

	protected String createBaseMenuItem() {
		StringBuffer sbf = new StringBuffer();
		
		if (icon != null){
			String img = createImg();
			sbf.append(img);
		}	
		
		sbf.append("<a href=\"");
		
		if (this.url != null){
			sbf.append(this.url);
		}else{
			sbf.append(ConstantKey.BASE_PROUNCE_STR);
		}
		sbf.append("\">");
		sbf.append(this.name);
		sbf.append("</a>");
		return sbf.toString();
	}
	*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setClass(String cls){
		this.classz = cls;
	}
	public void addSubMenuItem(MenuItem item){
		if ( subMenuMap == null){
			subMenuMap = new LinkedHashMap<String, MenuItem>();
		}
		
		if (subMenuMap.get(item.getId()) == null){
			subMenuMap.put(item.getId(), item);
		}
	}
	public Map<String, MenuItem> getSubMenuMap(){
		return this.subMenuMap;
	}
	
	public List<MenuItem> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<MenuItem> subMenuList) {
		this.subMenuList = subMenuList;
	}
	
}
