package com.home.maxwell.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	protected static final SimpleDateFormat DATE_FORMATTER_YYYYMMDD = new SimpleDateFormat("YYYYMMDD");
	
	public static String getDateFormatYYYYMMDD(Date date){
		return DATE_FORMATTER_YYYYMMDD.format(date);
	}
}
