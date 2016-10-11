package com.yxt.jhonelee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.HealthSignMapper;
import com.yxt.jhonelee.model.HealthSign;
import com.yxt.jhonelee.service.HealthSignService;

@Service
@Transactional
public class HealthSignServiceImpl implements HealthSignService {

	@Resource
	private HealthSignMapper mapper;
	


	@Override
	public List<HealthSign> HealthUserSignCount(int mNum, String codeValue, int startPos, int pageSize) {
		return mapper.HealthUserSignCount(mNum, codeValue, startPos, pageSize);
	}

	@Override
	public List<HealthSign> HealthDocSignCount(int mNum, String codeValue, int startPos, int pageSize) {
		return mapper.HealthDocSignCount(mNum, codeValue, startPos, pageSize);
	}

	@Override
	public int DocSignCount(int mNum, String mCodeValue) {
		return mapper.DocSignCount(mNum, mCodeValue);
	}

	@Override
	public int UserSignCount(int mNum, String mCodeValue) {
		return mapper.UserSignCount(mNum, mCodeValue);
	}

	@Override
	public List<HealthSign> noUserSign(int mTime) {
		return mapper.noUserSign(mTime);
	}

	@Override
	public List<HealthSign> noDocSign(int mTime) {
		return mapper.noDocSign(mTime);
	}

}
