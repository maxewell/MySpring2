<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!--
	
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
	<div id="menu">
		<ul id="mymenubar">
			<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="longdown"><img src="images/miinstall.gif"/>投保單位</span></a>
				<ul class="sub">
					<li><a href="#nogo21"><img src="images/icon_office_a.gif"/>勞保繳費證明申請(FRR100)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_abc.gif"/>勞退繳費證明申請(FRR101)</a></li>
					<li><a href="#nogo21"><img src="images/milics.gif"/>勞農保健保勞退異動(LA..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_caption.gif"/>投保單位通訊資料變更(CADDR..)</a></li>
				</ul>
			</li>
			<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="longdown"><img src="images/miinstall.gif">欠費繳納</span></a>
				<ul class="sub">
					<li><a href="#nogo21"><img src="images/icon_office_abc.gif"/>職業工會欠費申報(cfmtsb..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_caption.gif"/>職業工會欠費繳納申報(gnmtsb..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_light.gif"/>漁會欠費申報(FRRGA1DTL..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_list.gif"/>漁會欠費繳納申報(FRRGADTL..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_abc.gif"/>農會欠費申報(FKF100..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_abc.gif"/>農會欠費繳納申報(FKFGA..)</a></li>
				</ul>
			</li>
			<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down"><img src="images/miinstall.gif">職訓</span></a>
				<ul class="sub">
					<li><a href="#nogo21"><img src="images/icon_office_caption.gif"/>職業病健康檢查(ohus..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_caption.gif"/>職業訓練給付(cta..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_caption.gif"/>職業訓練結訓/離退(qta..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_caption.gif"/>職業傷病醫療書單(MNL..)</a></li>
				</ul>
			</li>
			<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down"><img src="images/miinstall.gif">國保</span></a>
				<ul class="sub">
					<li><a href="#nogo21"><img src="images/icon_office_light.gif"/>通訊資料變更上傳(MENPCADDR)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_light.gif"/>通訊資料變更回押(NPMECADDR)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_light.gif"/>繳費證明申請(APAS..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_light.gif"/>繳款單郵寄申請(EXT..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_light.gif"/>老年給付網路申辦(MENPOLDAPP)</a></li>
				</ul>
			</li>
			<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down"><img src="images/milics.gif">其他</span></a>
				<ul class="sub">
					<li><a href="#nogo21"><img src="images/icon_office_list.gif"/>補發繳款單回傳(INFANTLOG..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_list.gif"/>勞保老年給付申辦(MELAOB..)</a></li>
					<li><a href="#nogo21"><img src="images/icon_office_list.gif"/>勞工退休金申辦(MEPTXPS..)</a></li>
				</ul>
			</li>
			<li class="top"><a href="#nogo1" class="top_link"><span><img src="images/icon_office_disk.gif">健保局匯入</span></a></li>
		</ul>
	</div>
	 --%>
	<% 
		String menu = "<div id='menu'>MENU</div>";
		out.print(menu);
	 %> 
	<div id="content">
		<form>
			<fieldset>
				<legend>&nbsp;職業工會個人欠費試算-線上&nbsp;- 2</legend>
				<p id="pagedowntime">
                    網頁下載時間：民國101 年 04 月 17 日 10 時 25 分 06 秒
            	</p>
            	<p class="buttonline">
            		<button id="btn1" type="button" class="button_120">身分證號排序</button>&nbsp;
            		<button id="btn2" type="button" class="button_120">結束試算</button>&nbsp;
					<button id="btn3" type="button" class="button_120">身分證號排序</button>&nbsp;
					<button id="btn4" type="button" class="button_120">刪除所有</button>
            	</p>
            	<p>
            		<span id="unospan">保險證號：02999999S</span>
            		<span id="unamespan">單位名稱：勞工委員會勞工保險局</span>
            		<span id="oweymspan">保費年月：10101</span>
            	</p>
            	<hr/>
            
				<decorator:body />
			
				<p class="buttonline">
            		<button id="btn1" type="button" class="button_120">身分證號排序</button>&nbsp;
            		<button id="btn2" type="button" class="button_120">結束試算</button>&nbsp;
					<button id="btn3" type="button" class="button_120">身分證號排序</button>&nbsp;
					<button id="btn4" type="button" class="button_120">刪除所有</button>
            	</p>
			</fieldset>		
		</form>
		<div id="filler">&nbsp;</div>													
	</div>

	<div id="footer">
		show some feedback info
	</div>
</body>
</html>