;( function ($){
    $.fn.myprogress = function (settings){
        var _defaultSettings = {
            progress: 0,          //現在的progress
            msg: "處理中...",
            progdivClass: "MyProgress"  //
        };
        
        //用傳入的設定override掉default的設定
        var _settings = $.extend(_defaultSettings, settings);
        
        _settings.that = this;
        
        //檢查是否已加入<div id="progmsg">
        if ($(this).find("div#progmsg").length == 0) {
            $("<div id='progmsg'>" + _settings.msg + "</div>").appendTo($(this));
        }
        
        //檢查是否已加入<div id="progress">
        if ($(this).find("div#progress").length == 0){
            //一定要加\n
            $("<div id='progress'>\n" +
                "<span id='progress1'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "<span id='progress2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "<span id='progress3'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "<span id='progress4'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "<span id='progress5'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "<span id='progress6'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "<span id='progress7'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "<span id='progress8'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "<span id='progress9'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "<span id='progress9'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "<span id='prognum'>" +  "%</span>\n" + 
                "</div>").appendTo($(this));
        }
            
        _settings.graynum = Math.floor(_settings.progress / 10);     
        _settings.progessspans = $(this).find("#progress span[id^='progress']").each(function (idx){
            if (idx < _settings.graynum) {
                $(this).css('backgroundColor', 'gray');
            }else{
                $(this).css('backgroundColor', 'white');
            }
        })    
        
        _settings.progessspans = $(this).find("#progress span#prognum").each(function (idx){
            $(this).text(_settings.progress + "%");
        }) 
        
        $(this).addClass(_settings.progdivClass);
    }
})(jQuery);
