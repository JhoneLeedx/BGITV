package com.yxt.jhonelee.service;

import java.util.List;


import com.yxt.jhonelee.model.HomeBar;

public interface HomeBarService {

	public List<HomeBar> HomeSum(List<String> list,int mTime);	
	public List<HomeBar> HomeSumCount(List<String> list,int mNum,int mTime);
}
