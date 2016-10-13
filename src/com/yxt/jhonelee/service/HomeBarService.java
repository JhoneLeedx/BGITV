package com.yxt.jhonelee.service;

import java.util.List;


import com.yxt.jhonelee.model.HomeBar;

public interface HomeBarService {

	public List<HomeBar> HomeSum(String mCodeValue,int mTime);	
	public List<HomeBar> HomeSumCount(String mCodeValue,int mNum,int mTime);
}
