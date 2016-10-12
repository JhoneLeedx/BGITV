package com.yxt.jhonelee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yxt.jhonelee.model.HomeBar;

public interface HomeBarMapper {
    
	
	public List<HomeBar> HomeSum(String mCodeValue);	
	public List<HomeBar> HomeSumCount(@Param(value="mCodeValue")String mCodeValue,@Param(value="mNum")int mNum);	
	
}
