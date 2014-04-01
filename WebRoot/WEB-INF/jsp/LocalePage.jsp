<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
 --%>
<html>
<body>
<h1>Spring MVC internationalization example</h1>
<h2>
    In MVC Configuration XML File.
</h2>
<h3>
    The URL-MAP: ControllerClassNameHandlerMapping there is a property: 
</h3>
<h3>
    &ltinterceptors&gt
        localeChangeInterceptor
    &lt/interceptors&gt 
</h3>
<h3>
    &nbsp;&nbsp;&nbsp;
</h3>
<h3>
    &ltbean id="localeChangeInterceptor" class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor"&gt<br/>
    &nbsp;&nbsp;&nbsp;    &ltproperty name="paramName" value="language" /&gt<br/>
    &lt/bean&gt
</h3>
Language : <a href="locale/Show.so?language=en">English</a>|
<a href="locale/Show.so?language=zh_CN">Simplied-Chinese</a>|<a href="locale/Show.so?language="zh_TW">Traditional-Chineses</a>

<h3>
	welcome.springmvc : <spring:message code="welcome.springmvc" text="default text" /><br/>
	<%--
	stand JSTL: <fmt:message key="welcome.springmvc"/>
	 --%>
</h3>
    


Current Locale : ${pageContext.response.locale}

</body>
</html>