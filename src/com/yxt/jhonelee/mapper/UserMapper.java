package com.yxt.jhonelee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yxt.jhonelee.model.User;


public interface UserMapper {
	  public List<User> findUserBydocId();//查询所有用户
	  public List<User> findAllUser(int id);//查询某个医生id下的所有用户信息
	  public List<User> selectUserByPage(@Param(value = "id") int docid,
			  @Param(value = "startPos")int startPos,
			  @Param(value = "pageSize")int pageSize,
			  @Param(value="timeInt") int timeInt);//分页显示某个医生id下的所有用户信息
	  public int getUserCount(@Param(value = "id")int docid,@Param(value = "timeInt")int timeInt);//得到总数
	  public List<User> selectUserHomeBypage(@Param(value = "startPos")int startPos,@Param(value = "pageSize")int pageSize);//分页得到所有用户最新的数据
	  public int getHomeCount();//得到首页的数据的总数
	  
}
