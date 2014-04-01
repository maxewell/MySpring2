<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP Data input Form</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <h1>
    Spring input form
    </h1>
    <hr/>
    <table border="1">
        <thead>
            <tr>
            <th>SEQNO</th>
            <th>EMPID</th>
            <th>NAME</th>
            <th>DEPTID</th>
            <th>SALARY</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${dataList}" var="item" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${item.empId}</td>
            <td>${item.name}</td>
            <td>${item.deptId}</td>
            <td>${item.salary}</td>   
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr/>
    <form:form action="dbTx/InsertEmpSal.so" method="post">
        EMPID: <form:input id="empId" path="empId" size="5" maxlength="3" /><br/>
        NAME: <form:input id="name" path="name" size="10" maxlength="6" /><br/>
        DEPT: <form:input id="deptId" path="deptId" size="5" maxlength="3" /><br/>
        SALARY: <form:input id="salary" path="salary" size="10" maxlength="8" /><br/>
        <input type="submit" value="INSERT"/>
    </form:form>
    <hr/>
    <form action="dbTx/QueryEmpSal.so" metho="post">
        EMPID: <input type="text" name="empId"/><br/>
        <input type="submit" value="Query"/>
    </form>
  </body>
</html>
