/**
*	@name							Tabify
*	@descripton						Tabbed content with ease
*	@version						1.4
*	@requires						Jquery 1.3.2
*
*	@author							Jan Jarfalk
*	@author-email					jan.jarfalk@unwrongest.com
*	@author-twitter					janjarfalk
*	@author-website					http://www.unwrongest.com
*
*	@licens							MIT License - http://www.opensource.org/licenses/mit-license.php
*/

(function($){ 
     $.fn.extend({  
         mytab: function( index ) {
         	
			function getHref(el){
				hash = $(el).find('a').attr('href');
				//hash = hash.substring(0,hash.length-4);
                return hash;
			}
			
		 	function setActive(el){
		 		
				$(el).addClass('active');
				
                //$(getHref(el)).show("slow");
                $(getHref(el)).fadeIn("slow");
                                
				$(el).siblings('li').each(function(){
					$(this).removeClass('active');
					$(getHref(this)).hide();
				});
			}
			
			return this.each(function() {
			
				var self = this;
                
				var	callbackArguments 	=	{'ul':$(self)};
				
                tabarrs = $(this).find('li a').each(function(i){
                     this.onclick = function(){
                        setActive($(this).parent());
                        return false;
                    }
                     
                    if (index == undefined){
                         index = 0;    
                    } 
                    
                    if (i == index){
                        setActive($(this).parent());
                    }
                        
                });
            }); 
            
            function showProp(El){
                rs = "";
                for (var name in El) {
                    //rs += "[" + name + ":" + El[name] + "]";
                    rs += "[" + name +  "]";
                }
                alert(rs);
            }   
        } 
    }); 
})(jQuery);