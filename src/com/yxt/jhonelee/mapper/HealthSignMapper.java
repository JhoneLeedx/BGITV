package com.yxt.jhonelee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yxt.jhonelee.model.HealthSign;

public interface HealthSignMapper {

	public List<HealthSign> HealthUserSignCount(@Param(value = "mNum") int mNum,
			@Param(value = "mCodeValue") String mCodeValue, @Param(value = "startPos") int startPos,
			@Param(value = "pageSize") int pageSize);// 用户健康签到数据
	public int UserSignCount(@Param(value = "mNum") int mNum, @Param(value = "mCodeValue") String mCodeValue);//用户总数

	public List<HealthSign> HealthDocSignCount(@Param(value = "mNum") int mNum,
			@Param(value = "mCodeValue") String mCodeValue, @Param(value = "startPos") int startPos,
			@Param(value = "pageSize") int pageSize);// 医生健康签到数据

	public int DocSignCount(@Param(value = "mNum") int mNum, @Param(value = "mCodeValue") String mCodeValue);//医生总数
}
