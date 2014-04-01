<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}

</style>
</head>

<body>
<h2>Spring's 1 012</h2>
<div>OWEYM : ${OWEAPP.oweYm}</div>
<table>
	<th>
		<td>No.</td>
		<td>IDN</td>
	</th>
	<c:forEach items="${___OWE__CAL_LIST}" var="item" varStatus="status">
	<tr>
		<td>${status.count}</td>
		<td>${item.idn}</td>
	</tr>	
	</c:forEach>
</table>
<form:form method="POST" action="oweApp/QueryOweData.so">

<form:errors path="*" cssClass="errorblock" element="div"/>
<div>
	<span style="display:inline_block; width:10%;">idn1 : </span>
	<span style="display:inline_block; width:10%;"><form:input path="idn" /></span>
	<form:errors path="idn" cssClass="error" />
</div>
<input type="submit" />

</form:form>