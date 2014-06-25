<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>My Spring MVC Async Service example</h1>
    <hr/>
    <h2> Send File</h2>
    <form action="asyncTx/QueryTxProgress.so" method="post">
        <table>
            <thead>
                <tr><th>JobName</th></tr>
                <tr><th>JobTime(begin)</th></tr>
                <tr><th>JobTime(end)</th></tr>
                <tr><th>JobTime(Result)</th></tr>
            </thead>
            <tbody>
                <tr><td></td></tr>
                <tr><td></td></tr>
            </tbody>
        </table>
        <input type="submit" value="Send" />
    </form>
    <hr/>
</body>
</html>