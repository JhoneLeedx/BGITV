package com.yxt.jhonelee.util;

public class Test {
	public static void main(String[] args) {
		
		String m = Md5Util.EncoderByMd5("123456");
		System.out.println(m);
/*		List<User> list = new ArrayList<User>();
		for(int i=0;i<41;i++){
			User user = new User();
			user.setName((i+1)+"");
		    user.setId(i);
		    list.add(user);
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);*/
	}
}
