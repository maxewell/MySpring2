<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>My Spring MVC Async Service example</h1>
    <hr/>
    <h2> Query Async Status </h2>
    <form action="asyncTx/QueryTxProgress.so" method="post">
        <table border="1">
            <thead>
                <tr width="100%">
                    <th width="10%">TxName</th>
                    <th width="10%">TxTime(begin)</th>
                    <th width="10%">TxTime(end)</th>
                    <th width="10%">Status</th>
                    <th width="10%">Progress</th>
                    <th width="10%">Result</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${___ASYNC__SERVICE_STATUS.name }</td>
                    <td>${___ASYNC__SERVICE_STATUS.startTime }</td>
                    <td>${___ASYNC__SERVICE_STATUS.endTime }</td>
                    <td>${___ASYNC__SERVICE_STATUS.status }</td>
                    <td>${___ASYNC__SERVICE_STATUS.progress }</td>
                    <td>${___ASYNC__SERVICE_STATUS.txResult }</td>
                </tr>
                
            </tbody>
        </table>
        <input type="submit" value="Query" />
    </form>
    <hr/>
</body>
</html>