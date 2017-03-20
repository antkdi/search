package com.saramin.lab.search.common;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
	
	public boolean isNull(String str){
		boolean b = true;
		if(str != null)
			b = false;
		return b;
	}
	
	public String null2Str(String str,String def){
		if(str == null){
			return def;
		}else{
			return str;
		}
	}
	
}
