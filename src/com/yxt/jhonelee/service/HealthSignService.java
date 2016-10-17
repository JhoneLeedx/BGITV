package com.yxt.jhonelee.service;

import java.util.List;

import com.yxt.jhonelee.model.HealthSign;

public interface HealthSignService {

	public List<HealthSign> HealthUserSignCount(int mNum, List<String> list, int startPos, int pageSize);

	public List<HealthSign> HealthDocSignCount(int mNum, List<String> list, int startPos, int pageSize);

	public int DocSignCount(int mNum, List<String> list);

	public int UserSignCount(int mNum, List<String> list);
	
	public List<HealthSign> noUserSign(int mTime);//健康档案未签约用户扫码信息
	
	public List<HealthSign> noDocSign(int mTime);// 健康档案未签约医生扫码信息
}
