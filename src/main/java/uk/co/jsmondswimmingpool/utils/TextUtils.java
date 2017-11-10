package uk.co.jsmondswimmingpool.utils;

public class TextUtils {

	
	public static boolean isEmpty(String ...str) {
		for(String value:str) {
			if(value == null || "".equals(value.trim()))
				return true;
			
		}
		return false;
	}
	
	
	public static boolean isEmpty(String tr) {
	
		if(tr == null || "".equals(tr.trim()))
				return true;
		
		return false;
	}
	
	

}
