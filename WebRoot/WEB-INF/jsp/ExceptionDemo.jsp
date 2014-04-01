<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
    <h1>Spring MVC ExceptionDemo example</h1>
    <hr/>
    <c:if test="${command ne null}">
        <div>
            ${MYKEY}/${command.email}<br/>
        </div>
    <form:form>
        <form:errors path="*" cssClass="errorblock" element="div"/>
    </form:form>   
    </c:if> 
    <hr/>
</body>
</html>