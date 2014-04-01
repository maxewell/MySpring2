<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>Spring MVC FTP Service example</h1>
    <hr/>
    <h2> Send File</h2>
    <form action="ftp/FtpSend.so" method="post">
        Remote Dir: <input type="text" name="remoteDir" /><br/>
        Remote FileName: <input type="text" name="remoteFile" /><br/>
        Local FileName: <input type="text" name="localFile" /><br/>
        <input type="submit" value="Send" />
    </form>
    <hr/>
    <h2> Get File</h2>
    <form action="ftp/FtpGet.so" method="post">
        Remote Dir: <input type="text" name="remoteDir" /><br/>
        Remote FileName: <input type="text" name="remoteFile" /><br/>
        Local FileName: <input type="text" name="localFile" /><br/>
        <input type="submit" value="Send" />
    </form>
</body>
</html>