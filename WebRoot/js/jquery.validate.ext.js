(function() {
    $.extend(jQuery.validator.messages, {
          required: "必填欄位",
  		  email: "請輸入正確格式的電子郵件",
  		  url: "請輸入合法的網址",
		  date: "請輸入合法的日期",
		  dateISO: "請輸入合法的日期(ISO).",
		  number: "請輸入合法的數字",
		  digits: "只能輸入整數",
		  creditcard: "請輸入合法的信用卡號",
		  equalTo: "請再次輸入相同的值",
		  accept: "請輸入合法副檔名",
		  maxlength: jQuery.format("請輸入一個長度最多是 {0} 的字串"),
		  minlength: jQuery.format("請輸入一個長度最少是 {0} 的字串"),
		  rangelength: jQuery.format("請輸入一個長度介于 {0} 和 {1} 之間的字串"),
		  range: jQuery.format("請輸入一個介于 {0} 和 {1} 之間的值"),
		  max: jQuery.format("請輸入一個最大為 {0} 的值"),
		  min: jQuery.format("請輸入一個最小為 {0} 的值")
    });
})(jQuery); 