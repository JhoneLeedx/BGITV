package com.yxt.jhonelee.mapper;

import java.util.List;

import com.yxt.jhonelee.model.Admin;

public interface AdminMapper {

	public List<Admin> SelectAllAdmin(String adminName);//通过管理员的adminName查出所有管理员
	
}
