package com.yxt.jhonelee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yxt.jhonelee.model.User;


public interface UserMapper {
	  public List<User> findUserBydocId();
	  public List<User> findAllUser(int id);
	  public List<User> selectUserByPage(@Param(value = "id") int docid,@Param(value = "startPos")int startPos,@Param(value = "pageSize")int pageSize,@Param(value = "status")int status);
	  public int getUserCount(@Param(value = "id")int docid,@Param(value = "status")int status);
	  public List<User> selectUserHomeBypage(@Param(value = "startPos")int startPos,@Param(value = "pageSize")int pageSize);
	  public int getHomeCount();
	  
}
