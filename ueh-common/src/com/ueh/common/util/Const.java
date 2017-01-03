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
public final class Const {
					
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
	public static final String TMP_PATH="C:\\TMP";//临时目录
	public static final String BASE_PATH="C:\\files";//文件根目录
	public static final String CUSTOM_CODE="CUSTOM_CODE";//客户编码
	public static final String BP_METHOD = "BpMethod";//采购方式
	public static final String FILE_TYPE="FILE_TYPE";//文件类型（招标文件、投标文件等）
	public static final String FILE_ZBWJ="ZBWJ";
	public static final String FILE_TBWJ="TBWJ";
	public static Dict dict=new Dict();
	static{
		System.out.println("字典初始化...");
		put(CUSTOM_CODE, 0, "custom001");
		// 采购方式（按客户编码的不同，分为不同客户的招标方式字典）
		put(BP_METHOD+getKey(CUSTOM_CODE,"custom001"), 0, "公开招标");
		put(BP_METHOD+getKey(CUSTOM_CODE,"custom001"), 1, "邀请招标");
		put(BP_METHOD+getKey(CUSTOM_CODE,"custom001"), 2, "竞争性谈判");
		put(BP_METHOD+getKey(CUSTOM_CODE,"custom001"), 3, "单一来源采购");
		put(BP_METHOD+getKey(CUSTOM_CODE,"custom001"), 4, "询价");
		
		put(FILE_TYPE, 1, FILE_ZBWJ);//招标文件
		put(FILE_TYPE, 2, FILE_TBWJ);//投标文件
		
		/**
		 * 使用方式
		 */
		String xx=Const.get(Const.BP_METHOD,1);
		
		Integer key=Const.getKey(Const.BP_METHOD, "邀请招标");		
		
		Map<Object,String> methods= Const.get(Const.BP_METHOD);
		
		Collection<String> methodNames= Const.getValues(Const.BP_METHOD);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args){
		Map x=Const.get(BP_METHOD+getKey(CUSTOM_CODE,"custom001"));
		for(Object key:x.keySet())
		{
			System.out.println(x.get(key));
		}
		System.out.println("##############");
		//String json=AppConstants.getValuesJsonBy(AppConstants.BP_METHOD, "name");
		//System.out.println("json:"+json);
		String json=Const.getValuesJsonBy(BP_METHOD+getKey(CUSTOM_CODE,"custom001"), "name");
		System.out.println("json:"+json);
	}
	
	
}
