package com.ueh.common.util;


public class StringUtil {

	
	public static boolean  isEmpty(Object obj)
	{
		if(obj!=null&&!"".equals(obj.toString()))
			  return false;
		  else return true;
	}
	
	public static String stringify(String paramStr) {
		StringBuilder stringBuilder = new StringBuilder("{");
		String[] fields=paramStr.split("&");
		for(String field:fields){
			int index=field.indexOf('=');
			String fieldName = field.substring(0, index);
			String fieldValue = field.substring(index+1, field.length());
			stringBuilder.append(fieldName+":\""+fieldValue+"\",");
		}		
		int length = stringBuilder.length();
		if( stringBuilder.indexOf(",", length-1) > -1 ){
			stringBuilder.deleteCharAt(length-1);
		}
		stringBuilder.append("}");
		return stringBuilder.toString();
	}
}
