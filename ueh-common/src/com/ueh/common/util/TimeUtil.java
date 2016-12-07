package com.ueh.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar; 
 

public class TimeUtil {
	
	public static Long getTimeMillisMin(int date)
	{
		 String s=String.valueOf(date);
		 Calendar cale=Calendar.getInstance();
		 cale.set(Calendar.YEAR, Integer.parseInt(s.substring(0,4)));
		 cale.set(Calendar.MONTH, Integer.parseInt(s.substring(4,6))-1);
         cale.set(Calendar.DATE, Integer.parseInt(s.substring(6,8)));	
         cale.set(Calendar.HOUR_OF_DAY, 0);
         cale.set(Calendar.MINUTE,0);
         cale.set(Calendar.SECOND,0);
         cale.set(Calendar.MILLISECOND,0);
       	return cale.getTimeInMillis();
	}
	
	public static Long getTimeMillisMax(int date)
	{
		 String s=String.valueOf(date);
		 Calendar cale=Calendar.getInstance();
		 cale.set(Calendar.YEAR, Integer.parseInt(s.substring(0,4)));
		 cale.set(Calendar.MONTH, Integer.parseInt(s.substring(4,6))-1);
         cale.set(Calendar.DATE, Integer.parseInt(s.substring(6,8)));	
         cale.set(Calendar.HOUR_OF_DAY, 23);
         cale.set(Calendar.MINUTE,59);
         cale.set(Calendar.SECOND,59);
         cale.set(Calendar.MILLISECOND,999);
       	return cale.getTimeInMillis();
	}
	

	public static Long parseTime8(String s)
	{
		 Calendar cale=Calendar.getInstance();
		 cale.set(Calendar.YEAR, Integer.parseInt(s.substring(0,4)));
		 cale.set(Calendar.MONTH, Integer.parseInt(s.substring(4,6))-1);
         cale.set(Calendar.DATE, Integer.parseInt(s.substring(6,8)));	
         cale.set(Calendar.HOUR_OF_DAY, 0);
         cale.set(Calendar.MINUTE,0);
         cale.set(Calendar.SECOND,0);
         cale.set(Calendar.MILLISECOND,0);
       	return cale.getTimeInMillis();
	}
	
	
	public static Long parseTime14(String s)
	{ 
		 Calendar cale=Calendar.getInstance();
		 cale.set(Calendar.YEAR, Integer.parseInt(s.substring(0,4)));
		 cale.set(Calendar.MONTH, Integer.parseInt(s.substring(4,6))-1);
         cale.set(Calendar.DATE, Integer.parseInt(s.substring(6,8)));	
         cale.set(Calendar.HOUR_OF_DAY, Integer.parseInt(s.substring(8,10)));
         cale.set(Calendar.MINUTE,Integer.parseInt(s.substring(10,12)));
         cale.set(Calendar.SECOND,Integer.parseInt(s.substring(12,14)));
         cale.set(Calendar.MILLISECOND,0);
       	return cale.getTimeInMillis();
	}
	
	public static String parseString8(Long s)
	{ 
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");   
		return df.format(s);
	}
	
	public static String parseString14(Long s)
	{ 
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");   
		return df.format(s);
	}
	
	public static String getMDHM(Long s)
	{ 
		SimpleDateFormat df=new SimpleDateFormat("MM-dd HH:mm");   
		return df.format(s);
	}
	
	
	public static int getBeforeDay(int date)
	{
		 String s=String.valueOf(date);
		 Calendar cale=Calendar.getInstance();
		 cale.set(Calendar.YEAR, Integer.parseInt(s.substring(0,4)));
		 cale.set(Calendar.MONTH, Integer.parseInt(s.substring(4,6))-1);
         cale.set(Calendar.DATE, Integer.parseInt(s.substring(6,8))-1);
         SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd"); 
         return Integer.parseInt(df.format(cale.getTime()));
         
	}
	
	/*
	 * 寰楀埌鏄ㄥぉ 
	 */
	public static int getYesterday8()
	{
		 Calendar cale=Calendar.getInstance();
		 cale.add(Calendar.DAY_OF_MONTH, -1);
		 SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd"); 
        return Integer.parseInt(df.format(cale.getTime())); 
		
	}
	
	
	public static int getNextDay(int date)
	{
		 String s=String.valueOf(date);
		 Calendar cale=Calendar.getInstance();
		 cale.set(Calendar.YEAR, Integer.parseInt(s.substring(0,4)));
		 cale.set(Calendar.MONTH, Integer.parseInt(s.substring(4,6))-1);
        cale.set(Calendar.DATE, Integer.parseInt(s.substring(6,8))+1);
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd"); 
        return Integer.parseInt(df.format(cale.getTime())); 
	}
	
	public static int getCurrentYear4()
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy");
		String s=df.format(System.currentTimeMillis());
		return Integer.parseInt(s);
	}
	
	
	public static int getAgeFormIDCard(String idCard)
	{
		String bir=idCard.substring(6,10);
		return getCurrentYear4()-Integer.parseInt(bir);
	}
	
	
	public static int getBeforeMonth(int month)
	{
		if(month%100==1)
		{
			return month-89;
		}
		else
		{
			return month-1;
		} 
	}
	public static int getNextMonth(int month)
	{
		if(month%100==12)
		{
			return month+89;
		}
		else
		{
			return month+1;
		} 
	}
	
	public static int getCurrentDate8()
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		String s=df.format(System.currentTimeMillis());
		return Integer.parseInt(s);
	}
	
	public static int getCurrentMonth6()
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyyMM");
		String s=df.format(System.currentTimeMillis());
		return Integer.parseInt(s);
	}
	
	public static String getHM(Long s)
	{
		SimpleDateFormat df=new SimpleDateFormat("HH:mm");
		String str=df.format(s);
		return str;
	}
	
	public static String getMD(int date)
	{
		
		String s=String.valueOf(date);
		return s.substring(4,6)+"-"+s.substring(6,8);
		
	}
	public static int getCurrentDate()
	{
		Calendar cal = Calendar.getInstance();  
       return cal.get(Calendar.DATE);
		
	}

	public static int getCurrentMonthMaxDate()
	{
		Calendar cal = Calendar.getInstance();   
		int dateOfMonth = cal.getActualMaximum(Calendar.DATE); 
		return dateOfMonth;
		
	}
	
	public static int getWeekOfYear(Long date)
	{
		Calendar cal=Calendar.getInstance(); 
		cal.setTimeInMillis(date);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
	
	private static int getDay8(Calendar cale)
	{
		return cale.get(Calendar.YEAR)*10000+(cale.get(Calendar.MONTH)+1)*100+cale.get(Calendar.DATE); 
	}
	
	
	//寰楀埌涓婁釜鏈堢殑浠婂ぉ
	public static int getPreMonthDay(int currentDate)
	{
		int month=currentDate/100;
		return getBeforeMonth(month)*100+currentDate%100;
	}
	
	//寰楀埌涓婃湀浠婂ぉ鐨勫悗xx澶�
	public static int getPreMonthNextDay(int currentDate,int next)
	{
		 String s=String.valueOf(currentDate);
		 Calendar cale=Calendar.getInstance();
		 cale.set(Calendar.YEAR, Integer.parseInt(s.substring(0,4)));
		 cale.set(Calendar.MONTH, Integer.parseInt(s.substring(4,6))-2);
		 cale.set(Calendar.DATE, Integer.parseInt(s.substring(6,8)));
		 cale.add(Calendar.DAY_OF_MONTH, next);
		 return getDay8(cale);
	}
	
	//鍓嶅嚑澶�  鍏朵腑 00琛ㄧず鏈堟湯
	public static int[] getPreDay(int currentDate,int num)
	{
		 String s=String.valueOf(currentDate);
		 Calendar cale=Calendar.getInstance();
		 cale.set(Calendar.YEAR, Integer.parseInt(s.substring(0,4)));
		 cale.set(Calendar.MONTH, Integer.parseInt(s.substring(4,6))-1);
		 
		 if(s.endsWith("00"))
		 {
			 cale.set(Calendar.DATE,cale.getMaximum(Calendar.DATE));
		 }
		 else
		 {
         cale.set(Calendar.DATE, Integer.parseInt(s.substring(6,8)));	
		 }
         int[] rtn=new int[num];
         rtn[num-1]=getDay8(cale); 
 		 for(int i=1;i<num;i++)
		 {
			cale.add(Calendar.DAY_OF_MONTH, -1);
		    rtn[num-i-1]=getDay8(cale); 
		 }
         return rtn;
	}

	
 
	
	public static void main(String[] args)
	{
		int  s=20150410;
		Long a=TimeUtil.getTimeMillisMax(s);
		Long b=TimeUtil.getTimeMillisMin(s);
		System.out.println(a);
		System.out.println(b);
		System.out.println((b-a)/1000/60); 
		
		System.out.println(TimeUtil.getCurrentDate8());
		
		
		System.out.println(TimeUtil.getHM(System.currentTimeMillis()));
		
		System.out.println(TimeUtil.getCurrentMonth6());
		
		int c=201312*100+1;
		int d=201312*100+101;
		
		Long c1=TimeUtil.getTimeMillisMin(c);
		System.out.println(TimeUtil.parseString14(c1));
		Long d1=TimeUtil.getTimeMillisMin(d);
		System.out.println(TimeUtil.parseString14(d1));
		
		
		
		System.out.println(TimeUtil.getMD(20150413));
		
		System.out.println(TimeUtil.getCurrentMonthMaxDate());
		
		System.out.println(TimeUtil.getCurrentDate());
		
		
		
		System.out.println(TimeUtil.getBeforeDay(20000101));
		System.out.println(TimeUtil.getNextDay(20000301));
	
		System.out.println(TimeUtil.getBeforeMonth(201512));
		System.out.println(TimeUtil.getNextMonth(201512));

		System.out.println(TimeUtil.getTimeMillisMin(20150107));
		System.out.println(TimeUtil.getWeekOfYear(1420560000000L));
		
		
		int[] days=TimeUtil.getPreDay(20150100,3);
		for(int ds:days)
		{
			System.out.println(ds);
		}
		
		
		//寰楀埌涓婃湀浠婂ぉ
		System.out.println("----------------");
		System.out.println(TimeUtil.getPreMonthDay(20150708));
		System.out.println(TimeUtil.getPreMonthDay(20150101));
		System.out.println(TimeUtil.getPreMonthNextDay(20150708,2));
		System.out.println(TimeUtil.getPreMonthNextDay(20150131,2));
		
		System.out.println(TimeUtil.getYesterday8());
		
		
		System.out.println("--------澶╂暟宸�-------");		
		System.out.println(TimeUtil.dayBeforeDay(20151006,20151002));
		System.out.println(TimeUtil.dayBeforeDay(20150111,20141231));
	}
	
  	
	public static int  dayBeforeDay(int afterDay,int breforeDay)
	{
		 String s1=String.valueOf(afterDay);
		 Calendar cale1=Calendar.getInstance();
		 cale1.set(Calendar.YEAR, Integer.parseInt(s1.substring(0,4)));
		 cale1.set(Calendar.MONTH, Integer.parseInt(s1.substring(4,6))-1);
		 cale1.set(Calendar.DATE, Integer.parseInt(s1.substring(6,8)));	
		 Long time1=cale1.getTimeInMillis();
		 
		 String s2=String.valueOf(breforeDay);
		 Calendar cale2=Calendar.getInstance();
		 cale2.set(Calendar.YEAR, Integer.parseInt(s2.substring(0,4)));
		 cale2.set(Calendar.MONTH, Integer.parseInt(s2.substring(4,6))-1);
		 cale2.set(Calendar.DATE, Integer.parseInt(s2.substring(6,8)));	
		 Long time2=cale2.getTimeInMillis();
		 
		 long between_days=(time1-time2)/(1000*3600*24);  
		 return Integer.parseInt(String.valueOf(between_days));    

	}
 
	
}

