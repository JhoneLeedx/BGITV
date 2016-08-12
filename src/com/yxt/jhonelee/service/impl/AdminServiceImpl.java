package com.yxt.jhonelee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.AdminMapper;
import com.yxt.jhonelee.model.Admin;
import com.yxt.jhonelee.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminMapper mapper;
	@Override
	public List<Admin> SelectAllAdmin(String adminName) {
		// TODO Auto-generated method stub
		return mapper.SelectAllAdmin(adminName);
	}

}
