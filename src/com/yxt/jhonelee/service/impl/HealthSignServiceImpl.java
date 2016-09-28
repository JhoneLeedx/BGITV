package com.yxt.jhonelee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.HealthSignMapper;
import com.yxt.jhonelee.model.Docsignin;
import com.yxt.jhonelee.service.HealthSignService;

@Service
@Transactional
public class HealthSignServiceImpl implements HealthSignService {

	@Resource
	private HealthSignMapper mapper;
	
	@Override
	public List<Docsignin> HealthUserSignCount(int mNum,String codeValue) {
		// TODO Auto-generated method stub
		return mapper.HealthUserSignCount(mNum,codeValue);
	}

	@Override
	public List<Docsignin> HealthDocSignCount(int mNum, String codeValue) {
		// TODO Auto-generated method stub
		return mapper.HealthDocSignCount(mNum, codeValue);
	}

}
