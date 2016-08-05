package com.yxt.jhonelee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.UserMapper;
import com.yxt.jhonelee.model.User;
import com.yxt.jhonelee.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	public UserMapper userMapper;
	@Override
	public List<User> findAllUser(int docid) {
		// TODO Auto-generated method stub
		List<User> findAllUser = userMapper.findAllUser(docid);
		return findAllUser;
	}
	@Override
	public List<User> findUserBydocId() {
		// TODO Auto-generated method stub
		return userMapper.findUserBydocId();
	}
	@Override
	public List<User> selectUserByPage(int docid, int startPos, int pageSize,int status) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByPage(docid, startPos, pageSize,status);
	}
	@Override
	public int getUserCount(int docid,int status) {
		// TODO Auto-generated method stub
		return userMapper.getUserCount(docid,status);
	}
	@Override
	public List<User> selectUserHomeBypage(int startPos, int pageSize) {
		// TODO Auto-generated method stub
		return userMapper.selectUserHomeBypage(startPos, pageSize);
	}
	@Override
	public int getHomeCount() {
		// TODO Auto-generated method stub
		return userMapper.getHomeCount();
	}

}
