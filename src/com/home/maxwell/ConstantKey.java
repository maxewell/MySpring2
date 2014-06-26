package com.home.maxwell;

/**
 * 
 *  批次作業公用常數
 *
 * @修改清單
 * 1. MARK_DISK_CHECK_20120815:新增磁碟空間大小檢查作業
 * 
 */
public class ConstantKey {

	public static final String BASE_0_STR = "0";
	public static final String BASE_1_STR = "1";
	public static final String BASE_2_STR = "2";
	public static final String BASE_3_STR = "3";
	public static final String BASE_4_STR = "4";
	public static final String BASE_5_STR = "5";
	public static final String BASE_6_STR = "6";
	public static final String BASE_7_STR = "7";
	public static final String BASE_8_STR = "8";
	public static final String BASE_9_STR = "9";
	
	public static final String BASE_UP_A_STR = "A";
	public static final String BASE_UP_B_STR = "B";
	public static final String BASE_UP_C_STR = "C";
	public static final String BASE_UP_D_STR = "D";
	public static final String BASE_UP_E_STR = "E";
	public static final String BASE_UP_F_STR = "F";
	public static final String BASE_UP_G_STR = "G";
	public static final String BASE_UP_H_STR = "H";
	public static final String BASE_UP_I_STR = "I";
	public static final String BASE_UP_J_STR = "J";
	public static final String BASE_UP_K_STR = "K";
	public static final String BASE_UP_L_STR = "L";
	public static final String BASE_UP_M_STR = "M";
	public static final String BASE_UP_N_STR = "N";
	public static final String BASE_UP_O_STR = "O";
	public static final String BASE_UP_P_STR = "P";
	public static final String BASE_UP_Q_STR = "Q";
	public static final String BASE_UP_R_STR = "R";
	public static final String BASE_UP_S_STR = "S";
	public static final String BASE_UP_T_STR = "T";
	public static final String BASE_UP_U_STR = "U";
	public static final String BASE_UP_V_STR = "V";
	public static final String BASE_UP_W_STR = "W";
	public static final String BASE_UP_X_STR = "X";
	public static final String BASE_UP_Y_STR = "Y";
	public static final String BASE_UP_Z_STR = "Z";
	
	public static final String BASE_SPACE_STR = " ";
	public static final String BASE_COLON_STR = ":";
	public static final String BASE_COMMA_STR = ",";
	public static final String BASE_LEFT_SQUARE_BRACKETS_STR = "[";
	public static final String BASE_RIGHT_SQUARE_BRACKETS_STR = "]";
	//public static final String BASE_IN_PARENTH_LEFT_STR = "[";
	//public static final String BASE_IN_PARENTH_RIGHT_STR = "]";
	public static final String BASE_EMPTY_STR = "";
	public static final String BASE_DASH_STR ="-";
	public static final String BASE_UNDERSCORE_STR = "_";
	public static final String BASE_PERCENT_STR = "%";
	public static final String BASE_SHARP_STR = "#";
	public static final String BASE_LEFT_CURLY_BRACKETS_STR = "{";
	public static final String BASE_RIGHT_CURLY_BRACKETS_STR = "}";
	//public static final String BASE_XXXX_LEFT_STR = "{";
	//public static final String BASE_XXXX_RIGHT_STR = "}";
	public static final String BASE_OR_MARK_STR = "|";
	public static final String BASE_EQ_MARK_STR = "=";
	public static final String BASE_QUESTION_MARK_STR = "?";
	public static final String BASE_LEFT_PARENTHESES_STR= "(";
	public static final String BASE_RIGHT_PARENTHESES_STR= ")";	
	
	public static final String BASE_A_STR = "a";
	public static final String BASE_B_STR = "b";
	public static final String BASE_C_STR = "c";
	public static final String BASE_D_STR = "d";
	public static final String BASE_E_STR = "e";
	public static final String BASE_F_STR = "f";
	public static final String BASE_G_STR = "g";
	public static final String BASE_H_STR = "h";
	public static final String BASE_I_STR = "i";
	public static final String BASE_J_STR = "j";
	public static final String BASE_K_STR = "k";
	public static final String BASE_L_STR = "l";
	public static final String BASE_M_STR = "m";
	public static final String BASE_N_STR = "n";
	public static final String BASE_O_STR = "o";
	public static final String BASE_P_STR = "p";
	public static final String BASE_Q_STR = "q";
	public static final String BASE_R_STR = "r";
	public static final String BASE_S_STR = "s";
	public static final String BASE_T_STR = "t";
	public static final String BASE_U_STR = "u";
	public static final String BASE_V_STR = "v";
	public static final String BASE_W_STR = "w";
	public static final String BASE_X_STR = "x";
	public static final String BASE_Y_STR = "y";
	public static final String BASE_Z_STR = "z";
	
    public static final String SYSTEM_LINE_FEED = System.getProperty("line.separator");
    public static final String WIN_LINE_FEED = "\r\n";
	public static final String UNIX_LINE_FEED = "\n";
	
	/********************** FILE-ENCODING ***********************/
	public static final int ENCODING_UTF8_INDEX = 0;
	public static final int ENCODING_BIG5_INDEX = 1;
	public static final int ENCODING_ISO8895_INDEX =2;
	public static final String[] ENCODING_STR_ARRAY = {
		"UTF-8", "big5", "ISO-8895"
	};
	
	
	/*********************** AP ****************************/
	public static final String ATTR_SESSION_USER_MENU = "___USER__MENU";
    	
	/* --------------------------  Intercepter ------------------- */
	public static final String ENV_RUNTIME_ATTR ="___ENV__RUNTIME";
	public static final String REQUEST_OBJ_ATTR = "___REQUEST__OBJ";
	public static final String SPRING_CONTEXT_ATTR = "___SPRING__CONTEXT_OBJ";
	
	/* --------------------- AYNC_STATUS -------------------------- */
	public static final int ASYNC_STATUS_NEW = 0;   //
	public static final int ASYNC_STATUS_ENQ = 1;   //進Queue中
	public static final int ASYNC_STATUS_DEQ = 2;   //出Queue,進行執行
	public static final int ASYNC_STATUS_START = 3; //開始執行
	public static final int ASYNC_STATUS_DONE = 4;  //執行結束
	
	/* ********************** EdpFtpRunnableImpl- ********************* */
	public static String FTP_RUN_METHOD_GET = "get";
	public static String FTP_RUN_METHOD_PUT = "put";
	public static String FTP_RUN_METHOD = "method";
	public static String FTP_LOCAL_FILE = "localFile";
	public static String FTP_REMOTE_DIR = "remoteDir";
	public static String FTP_REMOTE_FILE = "remoteFile";
	public static String FTP_TYPE_IS_ASCII = "ftpFileTypeIsAscii";
}
