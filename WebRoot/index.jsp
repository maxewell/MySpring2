<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="menu" uri="http://com.home.menu/showUserMenu" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My Spring II</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<h1>
    This is my Spring Usage page.
    </h1>
    <hr/>
    <h2>Controller Demo</h2>
    In MVC configuration xml the URL-MAP is setting: ControllerClassNameHandlerMapping<br/>
    There is a controller: CustomerController. It has a methodNameResolver setting<br/>
      prefix : on  
    <h3>
        In the controller there is a method: onAddCustomer(...). The URL LINK is <a href="<c:url value='customer/AddCustomer.so'/>" />customer/AddCustomer.so</a><br/>
        In the controller there is a method: onDeleteCustomer(...). The URL LINK is <a href="<c:url value='customer/DeleteCustomer.so'/>" />customer/DeleteCustomer</a><br/>
        In the controller there is a method: onUpdateCustomer(...). The URL LINK is <a href="<c:url value='customer/UpdateCustomer.so'/>" />customer/UpdateCustomer</a><br/>
        In the controller there is a method: onListCustomer(...). The URL LINK is <a href="<c:url value='customer/ListCustomer.so'/>" />customer/ListCustomer</a><br/>
    </h3>
    <hr/>
    <h2>Locale Demo</h2>
    <a href="<c:url value='locale/Show.so' />" >Locale Demo</a>
    <hr/>
    <h2>PropertyPlaceholderConfigurer - Database Property change</h2>
    <a href="<c:url value='dbPropSwitch/Show.so' />" >DataBase Property</a>
    <hr/>
    <h2>Form Submit Validation Sample & multiple row input data Validation</h2>
    <a href="<c:url value='oweApp/Show.so' />" >OweApp</a>
    <hr/>
    <h2>Form Input Sample</h2>
    <a href="<c:url value='dbTx/Input.so' />" >FormInput</a>
    <%--
    <form action="dbTx/UpdateEmpSal.so" method="post">
    	EMPID: <input type="text" name="empId"/><br/>
    	SALARY: <input type="text" name="salary"/><br/>
    	<input type="submit" value="UPDATE"/>
    </form>
    
    <hr/>
    <form action="dbTx/QueryEmpSal.so" metho="post">
    	EMPID: <input type="text" name="empId"/><br/>
    	<input type="submit" value="Query"/>
    </form>
     --%>
    <hr/>
    <h2>Async Flow</h2>
    <h2>See the console: the thread name is different</h2>
    <a href="<c:url value='mock/AsyncRun.so' />" >Mock Async</a>
    <hr/>
    <h2>Schedule Flow</h2>
    <h2>after 10 sec</h2>
    <form action="mock/ScheduleRun.so" method="post">
        <input type="text" id="idn" name="IDN"/>
        <input type="submit" value="ScheduleRun" />
    </form>
    <hr/>
    <h2>Timer Flow</h2>
    <h2></h2>
    <form action="mock/TimeTaskRun.so" method="post">
        <input type="text" id="idn" name="IDN"/>
        <input type="submit" value="TimerRun" />
    </form>
    <hr/>
    <h2>FTP Service<a href="<c:url value='ftp/FtpForm.so' />" >Go TO FTP form</a></h2>
    <hr/>
    <h2>Mail Service<a href="<c:url value='mail/MailForm.so' />" >Go TO Mail form</a></h2>
    <hr/>
    <a href="<c:url value='formDemo/Show.so' />" >FormDemo</a><br/>
    <a href="<c:url value='exception/Show.so' />" >Exception</a><br/>
    <a href="<c:url value='asyncTx/RunAsyncTx.so?data=Taipei' />" >Async Action1</a>
    <a href="<c:url value='asyncTx/QueryTxStatusList.so' />" >Async Action1 Tx List Query </a>
    <a href="<c:url value='asyncTx/RunAsyncTxService.so' />" >Async Action Service</a> 
  </body>
</html>
