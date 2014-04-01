<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>Spring MVC Mail Service example</h1>
    <hr/>
    <h2> Send Mail</h2>
    <form action="mail/SendMail.so" method="post">
        To: <input type="text" name="tos" /><br/>
        From: <input type="text" name="from" /><br/>
        Subject: <input type="text" name="subject" /><br/>
        Mail Text: <input type="text" name="mailtext" /><br/>
        Attach File: <input type="text" name="attach" />
        <input type="submit" value="Send" />
    </form>
    <hr/>
</body>
</html>