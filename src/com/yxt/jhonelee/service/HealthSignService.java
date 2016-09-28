package com.yxt.jhonelee.service;

import java.util.List;

import com.yxt.jhonelee.model.Docsignin;

public interface HealthSignService {

	public List<Docsignin> HealthUserSignCount(int mNum,String codeValue);
	public List<Docsignin> HealthDocSignCount(int mNum,String codeValue);
}
