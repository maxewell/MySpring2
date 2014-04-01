package com.home.maxwell.view.menu;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.home.maxwell.view.menu.type2.BaseMenuItem;
import com.home.maxwell.view.menu.type2.BaseTopMenuItem;

public class MenuBuilder {

	public static String buildHtmlMenu(HttpSession session){
		if (session == null){
			return null;
		}
		List<MenuItem> itemlist = (List<MenuItem>)session.getAttribute("");
		
		StringBuffer sbf = new StringBuffer("<div id=\"menu\">");
		sbf.append("<ul>");
		for(MenuItem item : itemlist){
			String tmp = item.getHtmlMenu();
			sbf.append(tmp);
		}
		sbf.append("</ul>");
		sbf.append("/div>");
		return sbf.toString();
	}
	
	/*
	private static List<MenuItem> initTest() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	public static void main(String[] args){
		List<MenuItem> itemlist = initTest();
		//List<MenuItem> itemlist = initTestIE6();
		
		StringBuffer sbf = new StringBuffer("<div id=\"menu\">");
		sbf.append("<ul>");
		for(MenuItem item : itemlist){
			String tmp = item.getHtmlMenu();
			sbf.append(tmp);
		}
		sbf.append("</ul>");
		sbf.append("</div>");
		
		System.out.println(sbf.toString());
	}
	
	public static List<MenuItem> initTest(){
		MenuItem item;
		// 單筆申報  
		List<MenuItem> list = new ArrayList<MenuItem>();
		item = new BaseMenuItem("加保作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseMenuItem("退保作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseMenuItem("投保薪資調整作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseMenuItem("投保單位通訊相關資料變更");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		MenuItem item1 = new BaseMenuItem("單筆申報");
		item1.setIcon("images/icon_office_abc.gif");
		item1.setSubMenuList(list);
		
		// 批次申報  
		list = new ArrayList<MenuItem>();
		item = new BaseMenuItem("加保作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseMenuItem("退保作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseMenuItem("投保薪資調整作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		MenuItem item2 = new BaseMenuItem("批次申報");
		item2.setIcon("images/icon_office_abc.gif");
		item2.setSubMenuList(list);
		
		//申報查詢 / 修改 / 刪除 / 列印
		MenuItem item3 = new BaseMenuItem("申報查詢 / 修改 / 刪除 / 列印");
		item3.setIcon("images/icon_office_abc.gif");
	
		// 資料查詢 
		list = new ArrayList<MenuItem>();
		item = new BaseMenuItem("勞保單位繳費證明申請");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseMenuItem("職業傷病醫療書單申請");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		MenuItem item4 = new BaseMenuItem("資料查詢");
		item4.setIcon("images/icon_office_abc.gif");
		item4.setSubMenuList(list);
		
		// 勞保申辦作業 
		list = new ArrayList<MenuItem>();
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);
		
		item = new BaseTopMenuItem("勞保申辦作業");
		item.setClass("top");
		//item.setSubClass("first");
		item.setSubMenuList(list);
		item.setIcon("images/icon_office_abc.gif");
		
		// ROOT List
		List<MenuItem> menuList = new ArrayList<MenuItem>();
		menuList.add(item);
		
		return menuList;
	}
	/*
	public static List<MenuItem> initTestIE6(){
		MenuItem item;
		// 單筆申報  
		List<MenuItem> list = new ArrayList<MenuItem>();
		item = new BaseIE6MenuItem("加保作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseIE6MenuItem("退保作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseIE6MenuItem("投保薪資調整作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseIE6MenuItem("投保單位通訊相關資料變更");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		MenuItem item1 = new BaseIE6MenuItem("單筆申報");
		item1.setIcon("images/icon_office_abc.gif");
		item1.setSubMenuList(list);
		
		// 批次申報  
		list = new ArrayList<MenuItem>();
		item = new BaseIE6MenuItem("加保作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseIE6MenuItem("退保作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseIE6MenuItem("投保薪資調整作業");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		MenuItem item2 = new BaseIE6MenuItem("批次申報");
		item2.setIcon("images/icon_office_abc.gif");
		item2.setSubMenuList(list);
		
		// 申報查詢 / 修改 / 刪除 / 列印  
		MenuItem item3 = new BaseIE6MenuItem("申報查詢 / 修改 / 刪除 / 列印");
		item3.setIcon("images/icon_office_abc.gif");
	
		// 資料查詢 
		list = new ArrayList<MenuItem>();
		item = new BaseIE6MenuItem("勞保單位繳費證明申請");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		item = new BaseIE6MenuItem("職業傷病醫療書單申請");
		item.setIcon("images/icon_office_abc.gif");
		list.add(item);
		
		MenuItem item4 = new BaseIE6MenuItem("資料查詢");
		item4.setIcon("images/icon_office_abc.gif");
		item4.setSubMenuList(list);
		
		// 勞保申辦作業 
		list = new ArrayList<MenuItem>();
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);
		
		item = new BaseIE6TopMenuItem("勞保申辦作業");
		item.setClass("top");
		//item.setSubClass("first");
		item.setSubMenuList(list);
		item.setIcon("images/icon_office_abc.gif");
		
		// ROOT List
		List<MenuItem> menuList = new ArrayList<MenuItem>();
		menuList.add(item);
		
		return menuList;
	}*/
	
}

/*
 		<li class="top" style=""><a href="#" style="">PC</a>
			<ul class="first" style="">
				<li style=""><a href="#" style="">HP</a></li>
				<li style=""><a href="#" style="">IBM</a>
					<ul style="">
						<li style=""><a href=”#” style="">T Series</a>
							<ul style="">
								<li><a href="#" style="">T420S</a></li>
								<li><a href="#" style="">T430S</a></li>
							</ul>
						</li>
						<li><a href=”#” style="">S Serise</a></li>				
					</ul>
				</li>
			</ul>
		</li>
 */

/*
<div id="menu">
	<ul>
		<li><div class="downarrow"><a href="#" style="">勞保申辦作業</a></div>
			<ul>
				<li><div class="rightarrow"><a href="#">單筆申報</a></div>
					<ul>
						<li><a href=”#”>加保作業</a></li>
						<li><a href=”#”>退保作業</a></li>
						<li><a href=”#”>投保薪資調整作業</a></li>
						<li><a href=”#”>投保單位通訊相關資料變更</a></li>
					</ul>
				</li>
				<li><div class="rightarrow"><a href="#">批次申報</a></div>
					<ul>
						<li><a href=”#”>加保作業</a></li>
						<li><a href=”#”>退保作業</a></li>
						<li><a href=”#”>投保薪資調整作業</a></li>
					</ul>
				</li>
				<li><a href="#">申報查詢 / 修改 / 刪除 / 列印</a></li>
				<li><div class="rightarrow"><a href="#">申請作業</a></div>
					<ul>
						<li><a href="#">勞保單位繳費證明申請</a></li>
						<li><a href="#">職業傷病醫療書單申請</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><div class="downarrow"><a href="#">勞退申辦作業</a></div>
			<ul>
				<li><div class="rightarrow"><a href="#">單筆申報</a></div>
					<ul>
						<li><a href="#">提繳作業</a></li>
						<li><a href="#">停繳作業</a></li> 
						<li><a href="#">提繳工資調整作業</a></li>
					</ul>
				</li>
				<li><div class="rightarrow"><a href="#">批次申報</a></div>
					<ul>
						<li><a href="#">提繳作業</a></li>
						<li><a href="#">停繳作業</a></li> 
						<li><a href="#">提繳工資調整作業</a></li>
					</ul>
				</li>
				<li><a href="#">申報查詢 / 修改 / 刪除 / 列印</a></li>
				<li><div class="rightarrow"><a href="#">申請作業</a></div>
					<ul>
						<li><a href="#">提繳單位繳費證明申請</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><div class="downarrow"><a href="#">資料查詢</a></div>
			<ul>
				<li><a href="#">投保／提繳單位基本資料查詢</li>
				<li><a href="#">投保單位被保險人名冊下載</li>
				<li><a href="#">投保單位計費資料查詢</li>
				<li><a href="#">被保險人投保資料查詢</li>
			</ul>
		</li>
	</ul>
</div>
*/
