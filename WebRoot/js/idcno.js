function idChecker(input) /*函數宣告*/
{
    var pass=0; /*為了通過後面的防呆所以...*/
    var num=new Array(11); /*用來存轉換碼加九個數字 */
    var sum=0; /*計算經過公式後的加總*/
    var table=new Array(10,11,12,13,14,15,16,17,18,34,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33); /*轉換的對照表*/
    /*以下是防呆*/
    if(input.length!=10)
        return false;
    else if(input.charCodeAt(0)<"A".charCodeAt(0)||input.charCodeAt(0)>"Z".charCodeAt(0))
        return false;
    else if(input.charCodeAt(1)!="1".charCodeAt(0)&&input.charCodeAt(1)!="2".charCodeAt(0))
        return false;
    else
    {
        for(p=2;p<10;p++)
        {
            if(input.charCodeAt(p)<"0".charCodeAt(0)||input.charCodeAt(p)>"9".charCodeAt(0))
                break;
            else
                pass++;
        }
    }
    if(pass!=8)
        return false;
    /*以上是防呆*/
    num[1]=table[input.charCodeAt(0)-65]%10;
    num[0]=(table[input.charCodeAt(0)-65]-num[1])/10;
    for(p=1;p<10;p++)
        num[p+1]=input.charCodeAt(p)-48;
    for(p=1;p<9;p++)
        num[p]=num[p]*(10-p); /*套用公式*/
    for(p=0;p<11;p++)
        sum+=num[p];
    if(sum%10!=0) /*檢查*/
        return false;
    return true;
}