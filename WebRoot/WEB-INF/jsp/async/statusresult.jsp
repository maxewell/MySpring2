<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 
    <meta name="decorator" content="dashboard">
     -->
    <link rel="stylesheet" type="text/css" href="./css/NewProgress.css"></link>
    <script type="text/javascript" src="./js/MyNewProgress.js"></script>
    <script type="text/javascript">
        var time1;
        $(document).ready(function (){
            val = ${__ASYNC_STATUS_OBJ.progress};
            $('#Progressbar').myprogress({progress: val, msg: "is Busy ..."}); 
            
            if (val != 100){
                time1 = setInterval(queryStatus, 5000);
            }   
        });
        
        function queryStatus() {
            myurl = "asyncTx/QueryTxProgress.so";
            mydata = {"asyncStatusId": "${__ASYNC_STATUS_OBJ.txId}"}; 
                               
            myCallAjax(myurl, 
                    mydata,
                    null,
                    queryAsyncHandler,
                    ajaxErrorHandler
            );
        }
    
        function myCallAjax(myurl, mydata, apbefhandler, suchandler, errhandler){
           jQuery.ajax({
              type: "POST",
              url: myurl,
              cache: false,
              headers: {"Ajax": "true"},
              contentType: "application/x-www-form-urlencoded;charset=UTF-8",
              data: mydata,
              beforeSend: apbefhandler,
              dataType: "xml",        
              success:  suchandler, 
              error: errhandler
           });
        }
            
        function queryAsyncHandler(xml, textStatus, jqXHR){
            var progress = $(xml).find("PROGRESS").text()
            if (progress == '100'){
               clearInterval(time1); 
               //$('#Progressbar').hide();
            }
            
            var val = parseInt(progress, 10)
            $('#Progressbar').myprogress({progress: val, msg: "is Busy ..."});
            //alert(progress);
            
        }
    
        function ajaxErrorHandler (xml, textStatus, jqXHR) {
            alert("Sorry Ajax Error");
            clearInterval(time1);
            $('#Progressbar').hide();
        }
    </script>
     
</head>
<body>
    <div id="info">
        TxId: ${__ASYNC_STATUS_OBJ.txId}<br/>
        TxName: ${__ASYNC_STATUS_OBJ.txName}<br/>
        
    </div>
    <div id="Progressbar">
    </div>
</body>
</html>