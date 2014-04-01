<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>欠費試算</title>
    <link rel="stylesheet" type="text/css" href="./css/demo_page.css"/>
    <script type="text/javascript" src="./js/mybjajax.js"></script>
    <script type="text/javascript" src="./js/myvalidate.js"></script>
    <script type="text/javascript" src="./js/oweapp/meca10w010.js"></script>
    <style>
        #filler-2line{
            width: 100%;
            height: 2em;
        }
        .buttonline{
            margin: 1em;
            text-align: right
        }
        #unoInfo .line2-1{
            display: inline-block;
            width: 45%;
            text-align: center;
            margin-top: 1em;
            margin-bottom: 1em;
        }
        #inputArea .line2-1{
            display: inline-block;
            width: 30%;
            text-align: right;
            margin-top: 1em;
            margin-bottom: 1em;
        }
        .redcolor {
          font-weight: bold;
          color: red;
        }
        legend {
            font-weight: bold;
        }
        fieldset {
            height: 90%;
           
        }
    </style>
    <script type="text/javascript">
    </script>
</head>

<body>
<legend>&nbsp;<spring:message code="meca10w01.title" text="職業工會個人欠費試算"/>&nbsp;</legend>

    <div class="buttonline">
        <input class="button" id="submit" type="submit" value="<spring:message code='all.submit' text='xx'/>"/>
    </div>
    <hr/>
        <form:form method="POST" action="oweApp/QueryCalList.so">
        <form:errors path="*" cssClass="errorblock" element="div"/>
        <div id="unoInfo">
            <span class="line2-1"><spring:message code="all.unitno" text="xx"/>： 02999999S</span>
            <span><spring:message code="all.unitname" text="xxx"/>： 職業工會測試單位</span> 
        </div>
        <div id="inputArea">
            <span class="line2-1"><spring:message code="meca1.oweym" text="xxx"/>：</span><form:input path="oweYm" />
        <form:errors path="oweYm" cssClass="error" />
    </div>    
</form:form>
<div id="filler-2line"></div>
<hr size="1" noshade>
<div id="notice">
※注意事項：
1.＊符號為必須輸入欄位。
2.為避免網路壅塞狀況，請多利用<a href="/qa/main3.htm" target="_blank">投保單位批次申報程式</a>。
3.<a href="https://edesk.bli.gov.tw/na/enterAssocFishBillPrint.do?parameter=enterAssocFishBillPrint" target="_blank">補印繳款單</a>。
</div>
</body>