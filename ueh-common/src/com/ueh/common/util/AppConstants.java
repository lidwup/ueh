package com.ueh.common.util;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author
 */
@SuppressWarnings("unused")
public final class AppConstants {
					
	public static void put(final String storeName,Object key,String value){
		dict.put(storeName, key, value);
	}
	
	public static String get(final String storeName, Object key){
		return dict.get(storeName, key);
	}
	
	public static Map<Object, String> get(final String storeName){
		return dict.get(storeName);
	}
	
	public static int getKey(final String storeName,String value){
		return dict.getKey(storeName, value);
	}
	
	public static Collection<String> getValues(String mapName){
		return dict.getValues(mapName);
	}
	
	public static String getValuesJsonBy(String mapName,String name){
		StringBuffer jsonb=new StringBuffer("[");
		int length=jsonb.length();
		Collection<String> values=dict.getValues(mapName);
		for(String value:values){
			jsonb.append("{\""+name+"\":\""+value+"\"},");
		}
		if(jsonb.length()!=length){
			jsonb.deleteCharAt(jsonb.length()-1);
		}
		jsonb.append("]");
		return jsonb.toString();
	}
	
	public static final String BP_METHOD = "BpMethod";//采购方式
	public static Dict dict=new Dict();
	static{
		System.out.print("字典初始化...");
		// 采购方式
		put(BP_METHOD, 0, "公开招标");
		put(BP_METHOD, 1, "邀请招标");
		put(BP_METHOD, 2, "竞争性谈判");
		put(BP_METHOD, 3, "单一来源采购");
		put(BP_METHOD, 4, "询价");
		
		/**
		 * 使用方式
		 */
		String xx=AppConstants.get(AppConstants.BP_METHOD,1);
		
		Integer key=AppConstants.getKey(AppConstants.BP_METHOD, "邀请招标");		
		
		Map<Object,String> methods= AppConstants.get(AppConstants.BP_METHOD);
		
		Collection<String> methodNames= AppConstants.getValues(AppConstants.BP_METHOD);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args){
		Map x=AppConstants.get(AppConstants.BP_METHOD);
		for(Object key:x.keySet())
		{
			System.out.println(x.get(key));
		}
		System.out.println("##############");
		String json=AppConstants.getValuesJsonBy(AppConstants.BP_METHOD, "name");
		System.out.println("json:"+json);
	}
	
	
}
