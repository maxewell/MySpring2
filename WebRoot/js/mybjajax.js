			/*$("#loading").ajaxStart(function() {
                    $(this).show();
                    
            });
						
			$("#loading").ajaxComplete(function() {
                    $(this).hide();
            });
			*/

			var myajaxheader = {"MY-TYPE": "Ajax"};
            function myCallAjax(myurl, mydata, apbefhandler, suchandler, errhandler){
                    jQuery.ajax({
                       type: "POST",
                       url: myurl,
                       cache: false,
                       headers: myajaxheader,
                       data: mydata,
                       beforeSend: apbefhandler,
                       dataType: "xml",        
                       success:  suchandler, 
                       error: errhandler
                    });
            }
              
            function dbResetHandler(xml, textStatus, jqXHR){
                               var status = $(xml).find('STATUS').text();
                               var no = 0
                               if (status == '0') {
                                  no = parseInt($(xml).find('UPDATENO').text(), 10);
                                  $("#respmsg").text("更新成功" + no + "筆");
                                  $("#respmsg").css("color", "red");
                               }else if (status == "-99"){
                                  $("#respmsg").text("Session Timeout");
                                  $("#respmsg").css("color", "red");        
                               }else{
                                  $("#respmsg").text("更新失敗");
                                  $("#respmsg").css("color", "red");
                                         
                               }
                                   
            }
            
            function manualRunHandler(xml, textStatus, jqXHR){
                                   var status = $(xml).find('STATUS').text();
                                   var no = 0
                                   if (status == '0') {
                                      $("#respmsg").text("執行成功");
                                      $("#respmsg").css("color", "red");
                                   }else if (status == "-99"){
                                      $("#respmsg").text("Session Timeout");
                                      $("#respmsg").css("color", "red");        
                                   }else{
                                      $("#respmsg").text("執行失敗");
                                      $("#respmsg").css("color", "red");
                                   }
                                   
            }
            
            function ftpUpdateHandler(xml, textStatus, jqXHR){
                    var ip = $("#ftpip").find(":selected").text();   
                                    
                                   var status = $(xml).find('STATUS').text();
                                   var no = 0
                                   if (status == '0') {
                                      $("#respmsg").text("更新成功");
                                      $("#respmsg").css("color", "red");
                                      $("#LA_FTP_IP_INFO").text(ip);
                                      $("#LA_FTP_DIR_INFO").text($("#ftpdir").val());
                                   }else if (status == "-99"){
                                      $("#respmsg").text("Session Timeout");
                                      $("#respmsg").css("color", "red");        
                                   }else{
                                      $("#respmsg").text("更新失敗");
                                      $("#respmsg").css("color", "red");
                                   }
                                   
            }
            
           function emailAddHandler(xml, textStatus, jqXHR){
                                   var status = $(xml).find('STATUS').text();
                                   var no = 0
                                   if (status == '0') {
                                      var newHtml = '';
                                      var mailist = $(xml).find('Email');
                                      mailist.each(function(i){
                                        newHtml += '<tr><td>' + (i+1) + '</td><td>' + $(this).text() + '</td></tr>'
                                      }) 
                                      $("#maillist").html(newHtml);
                                      
                                      $("#respmsg").text("更新成功");
                                      $("#respmsg").css({"color": "red"});
                                   }else if (status == "-99"){
                                      $("#respmsg").text("Session Timeout");
                                      $("#respmsg").css("color", "red");        
                                   }else{
                                      $("#respmsg").text("更新失敗");
                                      $("#respmsg").css({'color':'red'});
                                   }
                                   
            }
            
            function emailDelHandler(xml, textStatus, jqXHR){
                                   var status = $(xml).find('STATUS').text();
                                   var no = 0
                                   if (status == '0') {
                                      
                                      var newHtml = '';
                                      var mailist = $(xml).find('Email');
                                      mailist.each(function(i){
                                        newHtml += '<tr><td>' + (i+1) + '</td><td>' + $(this).text() + '</td></tr>'
                                      }) 
                                      $("#maillist").html(newHtml);
                                      
                                      $("#respmsg").text("刪除成功");
                                      $("#respmsg").css({'color':'red'});
                                   }else if (status == "-99"){
                                      $("#respmsg").text("Session Timeout");
                                      $("#respmsg").css("color", "red");        
                                   }else{
                                      $("#respmsg").text("刪除失敗");
                                      $("#respmsg").css({'color':'red'});
                                   }
                                   
                               }
            
            function apBefSendHandler() {
                                   $("#respmsg").text("");
            }
            
            function ajaxErrorHandler (jqXHR, textStatus, errorThrown) {
                                   $("#respmsg").text("Ajax失敗");
                                   $("#respmsg").css("color", "red");
            }
            
            /*
            $("#MANUALRUN").ajaxStart(function() { 
               $(this).attr("disabled", true);
            }); 
            
            $("#DBRESET").ajaxStart(function() { 
               $(this).attr("disabled", true);
            });
            
            $("#FTPUPDATE").ajaxStart(function() { 
               $(this).attr("disabled", true);
            }); 
            
            $("#emailadd").ajaxStart(function() { 
               $(this).attr("disabled", true);
            }); 
            
            $("#emaildel").ajaxStart(function() { 
               $(this).attr("disabled", true);
            });
            
            $("#MANUALRUN").ajaxComplete(function() { 
               $(this).attr("disabled", false);
            });
  
            $("#DBRESET").ajaxComplete(function() { 
               $(this).attr("disabled", false);
            });
            
            $("#FTPUPDATE").ajaxComplete(function() { 
               $(this).attr("disabled", false);
            }); 
            
            $("#emailadd").ajaxComplete(function() { 
               $(this).attr("disabled", false);
            }); 
            
            $("#emaildel").ajaxComplete(function() { 
               $(this).attr("disabled", false);
            }); 
            */
            