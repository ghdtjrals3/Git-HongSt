package poly.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	public static String getDataTime(String fm) { 
		Date today = new Date();
		System.out.println(today);
		
		SimpleDateFormat date = new SimpleDateFormat(fm);
		
		return date.format(today);
	}
	
	public static String getDateTime() {
		return getDataTime("yyyy.MM.dd");
	}

}
