package com.yxt.jhonelee.service;

import java.util.List;


import com.yxt.jhonelee.model.HomeBar;

public interface HomeBarService {

	public List<HomeBar> HomeSum(String mCodeValue);	
	public List<HomeBar> HomeSumCount(String mCodeValue,int mNum);
}
