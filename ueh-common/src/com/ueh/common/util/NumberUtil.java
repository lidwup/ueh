package com.ueh.common.util;

import java.text.DecimalFormat;

public class NumberUtil {

	
	public static String  floatToShow(Float f)
	{
		String c=String.valueOf(f);
		return  c.substring(0,c.indexOf("."));
	}
	
	public static String floatPoint2(float f)
	{
		DecimalFormat decimalFormat=new DecimalFormat(".00");//
		return decimalFormat.format(f);
	}
	public static void main(String[] args)
	{
		String c=NumberUtil.floatPoint2(22.222f);	
		System.out.println(c);
	}
	
}
