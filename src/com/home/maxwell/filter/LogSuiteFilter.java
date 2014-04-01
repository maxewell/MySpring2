package com.home.maxwell.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.util.WebUtils;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.utils.DateUtils;

public class LogSuiteFilter implements Filter{
	/*
	protected static final List<String> CHANNEL_ID_LIST = new ArrayList<String>();
	static {
		CHANNEL_ID_LIST.add("TBS");
		CHANNEL_ID_LIST.add("TBSWEB");
		CHANNEL_ID_LIST.add("TBSAPP");
	} 
	*/ 
	
	protected static final String[] CHANNEL_ID_ARRAY = {
		"TBS",
		"TBSWEB", 
		"TBSAPP"}; 
	protected static final List<String> CHANNEL_ID_LIST = Arrays.asList(CHANNEL_ID_ARRAY); 
	
	protected static String USER_ID_ATTR = "___USER__ID";
	protected static String CHANNEL_ID_ATTR = "___CHANNEL_ID";
	protected static String PAGE_ID_ATTR = "___PAGE__ID";
	protected static String ACTION_ATTR = "___ACTION__ID";
	protected static String MODULE_ID_ATTR = "___MODULE__ID";
	protected static String FUNCTION_ID_ATTR = "___FUNCTION__ID";
	protected static String TXNCODE_ID_ATTR = "___TXNCODE__ID";
	
	protected FilterConfig config;
	
	public void destroy() {
		this.config = null;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		
		//取得進入時間
		long nowenter = System.currentTimeMillis();
		String dateyyyymmddstr = DateUtils.getDateFormatYYYYMMDD(new Date(nowenter));
		//取得SessionID
		String sessionid = WebUtils.getSessionId((HttpServletRequest)req);
		//取得userID
		String userid = (String)WebUtils.getSessionAttribute((HttpServletRequest)req, USER_ID_ATTR);
		//取得CHANNEL_ID
		String channelid = (String)WebUtils.getSessionAttribute((HttpServletRequest)req, CHANNEL_ID_ATTR);
		Assert.notNull(channelid, "channelID must not be null");
		//Assert.isTrue(CollectionUtils.containsInstance((Collection)CHANNEL_ID_LIST, channelid));
		Assert.isTrue(CHANNEL_ID_LIST.contains(channelid));
		//取得TXN_CODE
		//取得CTRL_CODE
		//取得TXN_NO
		String ctrlcode = null;
		String txncode = null;
		String action = ServletRequestUtils.getStringParameter(req, ACTION_ATTR);
		int channelidx = CHANNEL_ID_LIST.indexOf(channelid);
		switch(channelidx){
		case 0:
			String pageid = ServletRequestUtils.getStringParameter(req, PAGE_ID_ATTR);
			
			txncode = pageid + ConstantKey.BASE_DASH_STR + action;
			ctrlcode = "000";
			break;
		case 1:
			txncode = ServletRequestUtils.getStringParameter(req, TXNCODE_ID_ATTR);
			ctrlcode = "300";
			break;
		case 2:
			String module = ServletRequestUtils.getStringParameter(req, MODULE_ID_ATTR);
			String functionid = ServletRequestUtils.getStringParameter(req, FUNCTION_ID_ATTR);
			
			txncode = module + ConstantKey.BASE_DASH_STR + functionid + ConstantKey.BASE_DASH_STR + action;
			ctrlcode = "600";
			break;
		default:
			Assert.isTrue(false, "Invalid ChannelID");
		}
		//取得IP_ADDRESS
		String userip = req.getRemoteHost();
		//取得TXN_NO
		String txnno = CHANNEL_ID_ARRAY[channelidx] + dateyyyymmddstr + getSequence();
				
		//進行交易
		chain.doFilter(req, resp);
		
		//取得ELAPSED_TIME
		long nowleave = System.currentTimeMillis();
		long elasped = nowleave - nowenter;
		
		//取得RSP_CODE
		HttpServletResponse response = (HttpServletResponse)resp;
		//String rspcode = (HttpServletResponse)response.getStatus(resp);
		String rspcode = "5000";
		
		//記錄EJLog
		//ejLog.insert(nowlong, sessionid, userid, txncode, channelid, ctrcode, userip, elapsed, txnno, rspcode);
		//記錄OBSLog
		//ejLog.insert(nowlong, sessionid, userid, txnno, rspcode, ...);
		
	}

	private String getSequence() {
		//ORACLE: SEQUENCE內建
		//POSTGRE: SEQUENCE內建
		//DB2: SEQUENCE內建
		//Sybas: SEQUENCE內建
		//SQL Server: SEQUENCE內建(2012Version)
		return null;
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
