package tw.com.mypay;

import android.util.Log;

public class function {

	public static int ConvertStrToInt(String str_account) {		
		if (str_account.contains("$")){
			str_account=str_account.replace("$", "");			
		}		
		return (int) (Float.parseFloat(str_account));
	}
}
