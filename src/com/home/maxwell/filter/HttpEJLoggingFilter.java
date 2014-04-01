package com.home.maxwell.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.domain.EJLog;
import com.home.maxwell.service.EJLogService;

public class HttpEJLoggingFilter extends OncePerRequestFilter{
	protected static Logger logger = Logger.getLogger(HttpEJLoggingFilter.class);
	
	protected static String[] REQ_NOT_FILTERS_SUFFIX_DEFAULT = new String[]{
		".do",
		".so",
		".jsp",
		".html",
		".htm"
	};
	
	protected String[] reqNotFilterSuffixs = REQ_NOT_FILTERS_SUFFIX_DEFAULT;
	
	protected EJLogService ejLogService;
	
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String uri = request.getRequestURI();
		
		// "webcontext/" 要過濾處理
		String contextpath = request.getContextPath();
		if (uri.equals(contextpath)){
			return false;
		}else if (uri.equals(contextpath + "/")){
			return false;
		}
		
		for(String suffix : reqNotFilterSuffixs){
			if (uri.endsWith(suffix)){
				logger.info("URI:" + request.getRequestURI());
				//只有在REQ_NOT_FILTERS_SUFFIX，才要過濾處理
				return false;
			}
		}
		logger.info("URI:Pass Log : " + request.getRequestURI());
		//其他不要處裡
		return true;
	}
	
	protected void doFilterInternal(
			HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)
			throws ServletException, IOException {

		EJLog ejlog = new EJLog();
		long nowenter = System.currentTimeMillis();
		ejlog.setNowEnter(nowenter);
		
		String action = req.getRequestURI();
		ejlog.setAction(action);
		
		HttpSession session = req.getSession(false);
		if (session != null) {
			ejlog.setSessionId(session.getId());
		}
		
		String userIp = req.getRemoteAddr();
		ejlog.setUserIp(userIp);
		
		//String userid = 
		
		//
		AbstractMap<String, String[]> map = (AbstractMap<String, String[]>)req.getParameterMap();
		ejlog.setReq(reqMap2String(map));
		

		//為取得Response的文字進行置換
		PrintWriter out = resp.getWriter();
		HttpServletResponse response = new CharResponseWrapper((HttpServletResponse) resp);
		
		try {
			filterChain.doFilter(req, response);
			
			String servletResponseString = new String(response.toString());
			ejlog.setResp(servletResponseString);
			
			out.write(servletResponseString);
		}
		finally {
			long nowleave = System.currentTimeMillis();
			ejlog.setNowLeave(nowleave);
			
			long elasped = nowleave - nowenter;
			ejlog.setElaspedUsed(elasped);
			
			ejLogService.logEJ(ejlog);
		}
	}

	private String reqMap2String(AbstractMap<String, String[]> map) {
		String rs = ConstantKey.BASE_EMPTY_STR;
		
		if (map != null){
			Iterator<Entry<String, String[]>> it = map.entrySet().iterator();
			StringBuffer sbf = new StringBuffer(ConstantKey.BASE_LEFT_CURLY_BRACKETS_STR);
			if (it.hasNext()){
				Entry<String, String[]> entry = it.next();
				String key = entry.getKey();
				String[] values = entry.getValue();
				sbf.append(key).append(ConstantKey.BASE_EQ_MARK_STR); //key=
				for(String val: values){
					sbf.append(val).append(ConstantKey.BASE_OR_MARK_STR); //val1|val2|val3|
				}
			}
			while(it.hasNext()){
				sbf.append(ConstantKey.BASE_COMMA_STR).append(ConstantKey.BASE_SPACE_STR); //,
				Entry<String, String[]> entry = it.next();
				String key = entry.getKey();
				String[] values = entry.getValue();
				sbf.append(key).append(ConstantKey.BASE_EQ_MARK_STR); //key=
				for(String val: values){
					sbf.append(val).append(ConstantKey.BASE_OR_MARK_STR); //val1|val2|val3|
				} 
			}
			sbf.append(ConstantKey.BASE_RIGHT_CURLY_BRACKETS_STR);
			rs = sbf.toString();
		}
		
		return rs;
	}

	public String[] getReqNotFilterSuffixs() {
		return reqNotFilterSuffixs;
	}

	public void setReqNotFilterSuffixs(String[] reqNotFilterSuffixs) {
		this.reqNotFilterSuffixs = reqNotFilterSuffixs;
	}
	
	public EJLogService getEjLogService() {
		return ejLogService;
	}

	public void setEjLogService(EJLogService ejLogService) {
		this.ejLogService = ejLogService;
	}
	
}
