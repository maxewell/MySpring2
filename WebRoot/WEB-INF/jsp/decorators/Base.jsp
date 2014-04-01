<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="menu" uri="http://com.home.menu/showUserMenu" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="BJ Management"/>
    
	<title><decorator:title default="SiteMesh的裝飾器頁"/></title>
	 	
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/bjmenu3.css"/>
	<link rel="stylesheet" type="text/css" href="css/main.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="./css/mybj.css"/>
     -->
        
	<script type="text/javascript" src="js/jquery-1.5.2.js"></script>
	<script type="text/javascript" src="./js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="./js/jquery.validate.js"></script>
    <script type="text/javascript" src="./js/jquery.validate.ext.js"></script>
	<decorator:head />
	
	<!--
    <script type="text/javascript" src="./js/mybjajax.js"></script>
    <script type="text/javascript" src="./js/myvalidate.js"></script>
    -->

</head>
<body scroll="no">
	<div id="banner">
		<img src="images/title_unit.jpg" id="bliimg"/>
		<div id="duserinfo">
				<p>姓　　名：測試自然人2</p>
				<p>登入入日期：101 年 04 月 17 日</p>
				<p>登入時間：10:24</p>
				<p>您&nbsp;&nbsp;來&nbsp;&nbsp;自：10.7.17.102</p>
		</div>
	</div>
	
	<%-- 
		String menu = "<div id='menu'>MENU</div>";
		out.print(menu);
	 --%>
	<div id="menu">
	   <menu:showUserMenu/>
	</div>  
	<div id="content">
	   <fieldset>
	       <div align="right" id="showtime">
                                網頁下載時間：民國XXXXXX
            </div>
				<decorator:body />
       </fieldset>		
	   <div id="filler">&nbsp;</div>													
	</div>

	<div id="footer">
	   <span class="redcolor">
	       <c:choose>
	       <c:when test="${APCTL_STATUS_MSG ne null}">
	           ${APCTL_STATUS_MSG}
	       </c:when>
	       <c:otherwise>show some feedback info.</c:otherwise>
	       </c:choose>
	   </span>    
	</div>
</body>
</html>