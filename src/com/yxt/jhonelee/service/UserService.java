package com.yxt.jhonelee.service;

import java.util.List;

import com.yxt.jhonelee.model.User;

public interface UserService {
	
	List<User> findAllUser(int id);

	public List<User> findUserBydocId();

	public List<User> selectUserHomeBypage(int startPos, int pageSize, int timeInt, int code_value);

	public int getHomeCount(int timeInt, int code_value);

	public int getUserCount(int docid, int timeInt);

	public List<User> selectUserByPage(int docid, int startPos, int pageSize, int timeInt);
	
	
	public List<User> UserSignSum();//首页扫码数据
	public List<User> UserNoSignSum();//
	
	
	public String getCodeValueString(String mCodeValue);//得到codevalue

	
}
