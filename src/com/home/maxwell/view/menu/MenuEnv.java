package com.home.maxwell.view.menu;

import java.util.LinkedHashMap;
import java.util.Map;

import com.home.maxwell.view.menu.type1.BaseMenuItem;

@Deprecated
public class MenuEnv {

	public static Map<String, MenuItem> getAllMenuMap(){
		/*
		 * 
		 *    PC                       PHONE
		 *     ACER                     APPLE
		 *     ASUS                      iphone 3GS
		 *     IBM                       iphone 4S
		 *      T Series                 iphone 5S
		 *       T41                    HTC
		 *       T42                     Butterfly
		 *      X Series                 New One
		 *       X24                     Butterfly S
		 *       X30                    Google
		 *       X40                     Nexus S
		 *     Lenvo                     Nexus 4
		 *      IDEA PAD                LG
		 *                               F160
		 *                               G2
		 *                              SONG
		 *                              
		 */
		
		Map<String, MenuItem> map = new LinkedHashMap<String, MenuItem>();
		MenuItem item1000 = new BaseMenuItem("1000", "PC");
		MenuItem item1100 = new BaseMenuItem("1100", "Acer");
		MenuItem item1200 = new BaseMenuItem("1200", "Asus");
		MenuItem item1300 = new BaseMenuItem("1300", "IBM");
		MenuItem item1310 = new BaseMenuItem("1310", "T Sersies");
		MenuItem item1311 = new BaseMenuItem("1311", "T41");
		MenuItem item1312 = new BaseMenuItem("1312", "T42");
		MenuItem item1320 = new BaseMenuItem("1320", "X Sersies");
		MenuItem item1321 = new BaseMenuItem("1321", "X24");
		MenuItem item1322 = new BaseMenuItem("1322", "X30");
		MenuItem item1323 = new BaseMenuItem("1323", "X40");
		MenuItem item1400 = new BaseMenuItem("1400", "Lenovo");
		
		item1000.addSubMenuItem(item1100);
		item1000.addSubMenuItem(item1200);
		item1000.addSubMenuItem(item1300);
		item1000.addSubMenuItem(item1400);
		
		item1300.addSubMenuItem(item1310);
		item1300.addSubMenuItem(item1320);
		
		item1310.addSubMenuItem(item1311);
		item1310.addSubMenuItem(item1312);
		
		item1320.addSubMenuItem(item1321);
		item1320.addSubMenuItem(item1322);
		item1320.addSubMenuItem(item1323);
		
		MenuItem item2000 = new BaseMenuItem("2000", "Phone");
		MenuItem item2100 = new BaseMenuItem("2100", "APPLE");
		MenuItem item2110 = new BaseMenuItem("2110", "iphone 3GS");
		MenuItem item2120 = new BaseMenuItem("2120", "iphone 4S");
		MenuItem item2130 = new BaseMenuItem("2130", "iphone 5S");
		MenuItem item2200 = new BaseMenuItem("2200", "HTC");
		MenuItem item2210 = new BaseMenuItem("2210", "Butterfly");
		MenuItem item2220 = new BaseMenuItem("2220", "NewOne");
		MenuItem item2230 = new BaseMenuItem("2230", "Butterfly S");
		MenuItem item2300 = new BaseMenuItem("2300", "Google");
		MenuItem item2310 = new BaseMenuItem("2310", "Nexus");
		MenuItem item2320 = new BaseMenuItem("2320", "Nexus S");
		MenuItem item2330 = new BaseMenuItem("2330", "Nexus 4");
		MenuItem item2400 = new BaseMenuItem("2400", "LG");
		MenuItem item2410 = new BaseMenuItem("2410", "F160L");
		MenuItem item2420 = new BaseMenuItem("2420", "G Pro");
		MenuItem item2430 = new BaseMenuItem("2430", "G2");
		MenuItem item2500 = new BaseMenuItem("2500", "SONG");
		
		item2000.addSubMenuItem(item2100);
		item2000.addSubMenuItem(item2200);
		item2000.addSubMenuItem(item2300);
		item2000.addSubMenuItem(item2400);
		item2000.addSubMenuItem(item2500);
		
		item2100.addSubMenuItem(item2110);
		item2100.addSubMenuItem(item2120);
		item2100.addSubMenuItem(item2130);
		
		item2200.addSubMenuItem(item2210);
		item2200.addSubMenuItem(item2220);
		item2200.addSubMenuItem(item2230);
		
		item2300.addSubMenuItem(item2310);
		item2300.addSubMenuItem(item2320);
		item2300.addSubMenuItem(item2330);
		
		item2400.addSubMenuItem(item2410);
		item2400.addSubMenuItem(item2420);
		item2400.addSubMenuItem(item2430);
		
		map.put("1000", item1000);
		map.put("2000", item2000);
		
		return map;
	}
}
