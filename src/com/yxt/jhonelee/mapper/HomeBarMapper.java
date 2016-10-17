package com.yxt.jhonelee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yxt.jhonelee.model.HomeBar;

public interface HomeBarMapper {

	public List<HomeBar> HomeSum(@Param(value = "list")List<String> list, @Param(value = "mTime") int mTime);

	public List<HomeBar> HomeSumCount(@Param(value = "list")List<String> list, @Param(value = "mNum") int mNum,
			@Param(value = "mTime") int mTime);

}
