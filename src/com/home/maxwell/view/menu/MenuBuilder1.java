package com.home.maxwell.view.menu;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.beans.BeanUtils;

import com.home.maxwell.view.menu.type1.BaseMenuItem;

public class MenuBuilder1 {
	protected static String END_ZERO_3 = "000";
	protected static String END_ZERO_2 = "00";
	protected static String END_ZERO_1 = "0";
	protected static String[] ZEROS = new String[]{"0", "00", "000"};
	
	protected int menuIdLen = 4;
			
	public String createMenu(Map<String, MenuItem> allMenuMap, List<String> userMenuList ){
		String rs = null;
		if (userMenuList == null){
			return rs;
		}
	
		int cut = userMenuList.get(0).length() - menuIdLen;
		String premenu = userMenuList.get(0).substring(cut);
		Stack<String> stack = new Stack<String>();
		
		Map<String, MenuItem> menumap = new LinkedHashMap<String, MenuItem>();
		
		for(String menuid : userMenuList){
			MenuItem item = allMenuMap.get(menuid);
			if (item == null){
				continue;
			}
					
			stack.push(menuid);
			int idx = 0;
			if (menuid.endsWith(ZEROS[2])){
				idx = 3;
			}else if(menuid.endsWith(ZEROS[1])){
				idx = 2;
			}else if(menuid.endsWith(ZEROS[0])){
				idx = 1;
			}
						
			for (int i = idx; i < (menuIdLen-1) ; i++){
				String tmp = menuid.substring(0,  menuid.length() - (i+1)) + ZEROS[i];
				stack.push(tmp);
			}
			
			Map<String, MenuItem> basemap = menumap;
			MenuItem base = null;
			while(!stack.empty()){
				String key = stack.pop();
				
				if (basemap != null){
					item = basemap.get(key);
				
					if (item == null){
						item = allMenuMap.get(key);
						MenuItem newitem = new BaseMenuItem();
						BeanUtils.copyProperties(newitem, item);
						basemap.put(key, newitem);
						base = newitem;
					}else{
						base = item;
					}
					
					basemap = base.getSubMenuMap();
				}else{
					item = allMenuMap.get(key);
					MenuItem newitem = new BaseMenuItem();
					BeanUtils.copyProperties(newitem, item);
					base.addSubMenuItem(newitem);
					base = newitem;
					basemap = base.getSubMenuMap();
				}
				
			}
		}
		
		return null;
	}
	
	public static void main(String[] args){
		Stack<String> stack = new Stack<String>();
		String menuid = "ME2000";
		stack.push(menuid);
		
		int idx = 0;
		if (menuid.endsWith(ZEROS[2])){
			idx = 3;
		}else if(menuid.endsWith(ZEROS[1])){
			idx = 2;
		}else if(menuid.endsWith(ZEROS[0])){
			idx = 1;
		}
					
		for (int i = idx; i < 3; i++){
			String tmp = menuid.substring(0,  menuid.length() - (i+1)) + ZEROS[i];
			//System.out.println(tmp);
			stack.push(tmp);
		}
		
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
		
		/*
		Iterator<String> it = stack.iterator();
		while(it.hasNext()){
			System.out.println
		}*/
	}
}
