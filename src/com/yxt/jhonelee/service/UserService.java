package com.yxt.jhonelee.service;

import java.util.List;


import com.yxt.jhonelee.model.User;


public interface UserService {
     List<User> findAllUser(int id);
	  public List<User> findUserBydocId();
	  public List<User> selectUserHomeBypage(int startPos,int pageSize,int timeInt,List<Integer> list);
	  public int getHomeCount(int timeInt,List<Integer> list);
	  
	  
	  
	  public int getUserCount(int docid,int timeInt);
	  public List<User> selectUserByPage(int docid, int startPos, int pageSize,int timeInt);
}
