<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Spring MVC DataBase & Property Switch example</h1>
<h2>You must modify the PropertyPlaceholderConfigurer in the applicationContext.xml</h2>
<h2>and container server restart.</h2>
<hr/>
<h3>The Person Information:</h3>
firstName:${command.firstName}<br/>
lastName:${command.lastName}<br/>
email:${command.email }<br/>
car: A${command.car }
</body>
</html>