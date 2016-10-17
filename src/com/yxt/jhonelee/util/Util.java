package com.yxt.jhonelee.util;

import java.util.ArrayList;
import java.util.List;

public class Util {

	
	public static List<String> getCodeValues(String[] s){
		List<String> list = new ArrayList<String>();
		if(s.length>0){
			for(int i=0;i<s.length;i++){
				list.add(s[i]);
			}
			return list;
		}else{
			return null;
		}
	}
}
