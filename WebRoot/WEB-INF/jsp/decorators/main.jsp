<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<base href="<%=basePath%>"/>
		<meta http-equiv="pragma" content="no-cache"/>
        <meta http-equiv="cache-control" content="no-cache"/>
        <meta http-equiv="expires" content="0"/>
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
        <meta http-equiv="description" content="BJ Management"/>
        
		<title><decorator:title default="SiteMesh的裝飾器頁"/></title>
		
		<link href="css/main.css" rel="stylesheet" type="text/css">
		<!--
		<link rel="stylesheet" type="text/css" href="./css/bjmenu2.css"/>
        <link rel="stylesheet" type="text/css" href="./css/mybj.css"/>
         -->
         
		<script type="text/javascript" src="js/jquery-1.5.2.js"></script>
		<!--
        <script type="text/javascript" src="./js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="./js/mybjajax.js"></script>
        <script type="text/javascript" src="./js/jquery.validate.js"></script>
        <script type="text/javascript" src="./js/jquery.validate.ext.js"></script>
        <script type="text/javascript" src="./js/myvalidate.js"></script>
         -->
         
        <decorator:head/>
	</head>
	<body>
		<table width="100%" height="100%">
			<tr>
				<td valign="top">
					<!-- 引入一個頁面，臨時指定所用的裝飾器 -->
					<!--  
					<page:applyDecorator page="<c:url value='/decorators/book.html' />" name="panel" />
					<page:applyDecorator page="<c:url value='/decorators/link.html' />" name="panel" />
					 -->
					 
				</td>
				<td width="100%" valign="top">
					<table width="100%">
						<tr>
							<td id="pageTitle">
								<decorator:title/>
							</td>
						</tr>
						<tr>
							<td valign="top" height="100%">
								<decorator:body />
							</td>
						</tr>
						<tr>
							<td id="footer">
								<b>被包含的內容1</b><br>
								SithMesh提供頁面裝飾支援123
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
