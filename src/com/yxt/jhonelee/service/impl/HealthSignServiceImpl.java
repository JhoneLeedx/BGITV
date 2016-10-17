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
	public List<HealthSign> HealthUserSignCount(int mNum, List<String> list, int startPos, int pageSize) {
		return mapper.HealthUserSignCount(mNum, list, startPos, pageSize);
	}

	@Override
	public List<HealthSign> HealthDocSignCount(int mNum, List<String> list, int startPos, int pageSize) {
		return mapper.HealthDocSignCount(mNum, list, startPos, pageSize);
	}

	@Override
	public int DocSignCount(int mNum, List<String> list) {
		return mapper.DocSignCount(mNum, list);
	}

	@Override
	public int UserSignCount(int mNum, List<String> list) {
		return mapper.UserSignCount(mNum, list);
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
