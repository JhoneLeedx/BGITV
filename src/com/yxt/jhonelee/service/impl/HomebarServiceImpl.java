package com.yxt.jhonelee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.HomeBarMapper;
import com.yxt.jhonelee.model.HomeBar;
import com.yxt.jhonelee.service.HomeBarService;

@Service
@Transactional
public class HomebarServiceImpl implements HomeBarService{

	@Resource
	private HomeBarMapper mapper;
	

	@Override
	public List<HomeBar> HomeSum(String mCodeValue, int mTime) {
		// TODO Auto-generated method stub
		return mapper.HomeSum(mCodeValue,mTime);
	}

	@Override
	public List<HomeBar> HomeSumCount(String mCodeValue, int mNum, int mTime) {
		// TODO Auto-generated method stub
		return mapper.HomeSumCount(mCodeValue,mNum,mTime);
	}

}
