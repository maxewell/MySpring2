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
<h2>Spring1</h2>
<div>OWEYM : ${command.oweYm}</div>


<form:form method="POST" action="oweApp/QueryOweData.so" commandName="command">

<form:errors path="*" cssClass="errorblock" element="div"/>
<form:hidden path="oweYm" />
<c:forEach items="${command.oweCalList}" var="owecal" varStatus="status">
<div>
	<span style="display:inline_block; width:10%;">idn1 : </span>
	<span style="display:inline_block; width:10%;">
	   <input type="text" name="oweCalList[${status.index}].idn" value="${owecal.idn}" >
	</span>
	&nbsp;&nbsp;
	<span style="display:inline_block; width:10%;">
	   <%-- You can use normal html or Spring form tag,
	      you must note that the name must be "oweCalList[i].brate"
	   <input type="text" name="oweCalList[${status.index}].brdate" value="${owecal.brdate}" >
	    --%>
	   <form:input path="oweCalList[${status.index}].brdate" /> 
	</span>
	<%-- Note: path="oweCalList[i].idn" --%>
	<form:errors path="oweCalList[${status.index}].idn" cssClass="error" />
	
</div>
</c:forEach>
<input type="submit" />

</form:form>
<hr/>
<c:if test="${___OWE__CAL_LIST != null}">
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
	<c:set var="calcount" value="${status.count}"/>
	</c:forEach>
	<tfoot>
	<tr>
		<td colspan="2">Total: ${calcount} Records.</td> 
	</tr>	
	</tfoot>
</table>

</c:if>
