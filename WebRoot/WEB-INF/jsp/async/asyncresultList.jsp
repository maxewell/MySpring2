<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>My Spring MVC Async Service example</h1>
    <hr/>
    <h2> Query Async Status List </h2>
    <form action="asyncTx/QueryTxProgress.so" method="post">
        <table border="1">
            <thead>
                <tr width="100%">
                    <th width="10%">No</th>
                    <th width="10%">TxName</th>
                    <th width="10%">TxTime(begin)</th>
                    <th width="10%">TxTime(end)</th>
                    <th width="10%">Status</th>
                    <th width="10%">Progress</th>
                    <th width="10%">Result</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach items="${___ASYNC__TX_LIST}" var="item" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${item.name }</td>
                    <td>${item.startTime }</td>
                    <td>${item.endTime }</td>
                    <td>${item.status }</td>
                    <td>${item.progress }</td>
                    <td>${item.result }</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="Query" />
    </form>
    <hr/>
</body>
</html>