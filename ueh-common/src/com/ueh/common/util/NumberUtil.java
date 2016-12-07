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
		DecimalFormat decimalFormat=new DecimalFormat(".00");//鏋勯�鏂规硶鐨勫瓧绗︽牸寮忚繖閲屽鏋滃皬鏁颁笉瓒�浣�浼氫互0琛ヨ冻.
		return decimalFormat.format(f);
	}
	public static void main(String[] args)
	{
		String c=NumberUtil.floatPoint2(22.222f);	
		System.out.println(c);
	}
	
}
