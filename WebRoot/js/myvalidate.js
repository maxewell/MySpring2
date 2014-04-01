jQuery.validator.addMethod("vidn",  idnValidate,    "身分證號檢核錯誤"   );
jQuery.validator.addMethod("vbjdate",  bjdateValidate,  "請輸入正確日期(YYYYMMDD)"   );
jQuery.validator.addMethod("vblidate",  blidateValidate,    "請輸入正確日期(YYYMMDD)"   );
jQuery.validator.addMethod("math",  mymath,  jQuery.format("Please enter the correct value for {0} + {1}")  );

function mymath (value, element, params) { 
    //$("#rs").text( params[0] +  params[1] + "||" + value); 
    return this.optional(element) || value == parseInt(params[0], 10) + parseInt(params[1],10); 
}

function idnValidate(val, element) {
    return this.optional(element) || isIdn(val);
}

function bjdateValidate(val, element){
    return this.optional(element) || isbjDate(val);   
}

function blidateValidate(val, element){
    return this.optional(element) || isbliDate(val);
}

function isIdn(val){
    citizenid = val.replace(/\s+/g, "");
    rs1 = /^[A-Z]{1}[1-2]{1}[0-9]{8}$/.test(citizenid);
    
    var local_table = [10,11,12,13,14,15,16,17,34,18,19,20,21,
                           22,35,23,24,25,26,27,28,29,32,30,31,33];
                       /* A, B, C, D, E, F, G, H, I, J, K, L, M,
                          N, O, P, Q, R, S, T, U, V, W, X, Y, Z */
                       
                           
    var local_digit = local_table[citizenid.charCodeAt(0)-'A'.charCodeAt(0)];
 
    var checksum = 0;
 
    checksum += Math.floor(local_digit / 10);
    checksum += (local_digit % 10) * 9;
 
      /* i: index; p: permission value */
      /* this loop sums from [1] to [8] */
      /* permission value decreases */
 
    for (var i=1, p=8; i <= 8; i++, p--)   {
        checksum += parseInt(citizenid.charAt(i)) * p;
    }
 
    checksum += parseInt(citizenid.charAt(9));    /* add the last number */
 
    rs2 = !(checksum % 10)
    
    return rs1 && rs2;
}

function isbjDate(val){
    rs1 = /^[2]{1}[0]{1}[0-9]{2}[01]{1}[0-9]{1}[0123]{1}[0-9]{1}$/.test(val);
    
    yyyy = val.substr(0, 4);
    mm = val.substr(4, 2)-1;
    dd = val.substr(6, 2);
    
    //$("#rs").text(yyyy + "|" + mm + "|" + dd);
    var mydate = new Date();
    mydate.setFullYear(yyyy, mm, dd);
    
    rs2 = true;
    if (mydate.getFullYear() != yyyy){
        rs2 = false;
    }
    
    rs3 = true;
    if (mydate.getMonth() != mm){
        rs3 = false;
    }
    
    rs4 = true;
    if (mydate.getDate() != dd){
        rs4 = false;
    }
    
    //$("#rs").text(mydate.getFullYear() + "|" + mydate.getMonth() + "|" + mydate.getDate());
        
    return rs1 && rs2 && rs3 && rs4;
}

function isbliDate(val){
    
}
