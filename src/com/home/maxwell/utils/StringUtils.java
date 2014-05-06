package com.home.maxwell.utils;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class StringUtils {
	static CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder(); // or "ISO-8859-1" for ISO Latin 1
	static String ASCII_PATTERN_STR = "\\A\\p{ASCII}*\\z";
	
	public static boolean isPureAscii(String v) {
		return asciiEncoder.canEncode(v);
	}
	
	public static boolean isMatchAscii(String data){
		return data.matches(ASCII_PATTERN_STR);
	}
}
