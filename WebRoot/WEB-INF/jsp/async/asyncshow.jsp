<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>My Spring MVC Async Service example</h1>
    <hr/>
    <h2> Anonymous async run</h2>
    <form action="asyncTx/RunAsyncTx.so" method="post">
        data: <input type="text" name="data" value="taipei"/><br/>
        <input type="submit" value="Async anonymous Run" />
    </form>
    <hr/>
    <h2> Async Action Service</h2>
    <form action="asyncTx/RunAsyncTxService.so" method="post">
        <input type="submit" value="Async Run Ftp Service" />
    </form>
    <hr/>
    <h2> Async Action Query</h2>
    <form action="asyncTx/QueryTxStatusList.so" method="post">
        <input type="submit" value="Query Async Status" />
    </form>
</body>
</html>