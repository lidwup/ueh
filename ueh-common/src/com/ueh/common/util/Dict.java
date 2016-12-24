package com.ueh.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public class Dict extends HashMap<String, Map<Object, String>> {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void put(String mapName, Object key, String value){
		if(!this.containsKey(mapName)){
			Map tmap=new HashMap();
			tmap.put(key, value);
			this.put(mapName, tmap);
		}
		else
		{
			Map tmap=this.get(mapName);
			tmap.put(key, value);
		}	
	}
	
	public Integer getKey(String mapName,String value){
		return Integer.parseInt(getDictKey(mapName, value));
	}
	
	public String getDictKey(String mapName, String value){
		if(!this.containsKey(mapName)){
			return "-1";
		}else if(!this.get(mapName).containsValue(value)){
			return "-1";
		}else{
			Map<Object,String> tmap= this.get(mapName);
			for(Object key:tmap.keySet()){
				if(tmap.get(key).equals(value))
					return key.toString();	
			}		
		}
		return "-1";
	}
	
	public String get(String mapName,Object key){
		if(!this.containsKey(mapName)){
			return null;
		}
		else if(!this.get(mapName).containsKey(key)){
			return null;
		}
		else
		{
			Map<Object,String> tmap=this.get(mapName);
			return tmap.get(key);
		}		
	}
	
	public Collection<String> getValues(String mapName){
		if(!this.containsKey(mapName)){
			return null;
		}
		else
		{
			Map<Object,String> tmap=this.get(mapName);
			List<String> valueList=new ArrayList<String>();
			
			return tmap.values();
		}
}
	
	public static void main(String[] args){
		Dict dict=new Dict();
		dict.put("学历", 1, "小学");
		dict.put("学历", 2, "中学");
		dict.put("学历", 3, "大学");
		dict.put("职称", 1, "助工");
		dict.put("职称", 2, "工程师");
		dict.put("职称", 3, "高级工程师");
		
		for(String key:dict.keySet()){
			for(Object key2:dict.get(key).keySet()){
				System.out.println(key+"/"+key2+"/"+dict.get(key).get(key2));
			}
		}
		
		System.out.println(dict.getKey("学历", "大学"));
		System.out.println(dict.getDictKey("学历", "大学"));
		
		Collection x=dict.getValues("学历");
		for(Object d:x){
			System.out.println("VALUE:"+d.toString());
		}
	}
}
