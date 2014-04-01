<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
   
  </head>
  
  <body>
    <h1>
    This is my Spring Controller Demo page.
    </h1>
    <hr/>
    <form:form action="formDemo/UpdateRef.so" method="post">
        <label>Name:</label><input type="edit" name="name" value="maxwell" /><br/>
        <label>interest:</label>
        Quidditch: <form:checkbox path="preferences.interests" value="Quidditch"/>
        Herbology: <form:checkbox path="preferences.interests" value="Herbology"/>
        Defence Against the Dark Arts: <form:checkbox path="preferences.interests" value="Defence Against the Dark Arts"/><br/>
        <input type="submit" name="submit1" value="submit1"/>
        <hr/>
         
        <label>Test List</label>
        <form:checkboxes items="${interestList}" path="preferences.interests"/><br/>
        <input type="submit" name="submit2" value="submit2"/>
        
    </form:form>
  </body>
</html>
