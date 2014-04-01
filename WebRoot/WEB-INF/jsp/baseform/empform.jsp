<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP Data List Form</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <h1>
    Spring query form
    </h1>
    <hr/>
    <form:form action="dbTx/UpdateEmpSal.so" method="post">
        <form:input id="empId" path="empId" /><br/>
        <form:input id="name" path="name" /><br/>
        <form:input id="deptId" path="deptId" /><br/>
        <form:input id="salary" path="salary" /><br/>
        <input type="submit" value="Update" />
    </form:form>
  </body>
</html>
