package com.yxt.jhonelee.service;

import java.util.List;

import com.yxt.jhonelee.model.HealthSign;

public interface HealthSignService {

	public List<HealthSign> HealthUserSignCount(int mNum, String codeValue, int startPos, int pageSize);

	public List<HealthSign> HealthDocSignCount(int mNum, String codeValue, int startPos, int pageSize);

	public int DocSignCount(int mNum, String mCodeValue);

	public int UserSignCount(int mNum, String mCodeValue);
	
	public List<HealthSign> noUserSign();//健康档案未签约用户扫码信息
	
	public List<HealthSign> noDocSign();// 健康档案未签约医生扫码信息
}
