package uk.co.jsmondswimmingpool.utils;

import java.util.List;

import uk.co.jsmondswimmingpool.entity.Achievement;

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
	
	
	
	public static boolean isNullId(Long ...tr) {
		for (Long long1 : tr) {
			if(long1 == null || long1<=0)
				return true;		
		}
		
		
		return false;
	}


	public static boolean isListEmpty(List<Achievement> selectByExample) {
		if(selectByExample==null || selectByExample.isEmpty())
			return true;
		return false;
	}
	
	

}
