package com.ueh.common.util;

public class StringUtil {

	
	public static boolean  isEmpty(Object obj)
	{
		if(obj!=null&&!"".equals(obj.toString()))
			  return false;
		  else return true;
	}
	
	
}
