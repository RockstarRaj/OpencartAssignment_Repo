package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FunctionLibrary {
	public static String UEmailId()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMHHmm");
		Date Cdate = new Date();
		String Uid = "User"+sdf.format(Cdate).toString();
		return Uid;
	}
	

}
