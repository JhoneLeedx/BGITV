package com.yxt.jhonelee.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.AdminMapper;
import com.yxt.jhonelee.model.ITVRecord;
import com.yxt.jhonelee.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Resource
	AdminMapper mapper;

	@Override
	public ITVRecord SelectAllRecord(int id) {
		// TODO Auto-generated method stub
		return mapper.SelectAllRecord(id);
	}

	@Override
	public boolean InsertRecord(ITVRecord itvRecord) {
		// TODO Auto-generated method stub
		return mapper.InsertRecord(itvRecord);
	}
	
}
