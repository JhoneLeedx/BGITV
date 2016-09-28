package com.yxt.jhonelee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yxt.jhonelee.model.Docsignin;

public interface HealthSignMapper {
	public List<Docsignin> HealthUserSignCount(@Param(value="mNum")int mNum);
	public List<Docsignin> HealthDocSignCount(@Param(value="mNum")int mNum,@Param(value="mCodeValue")String mCodeValue);
}
