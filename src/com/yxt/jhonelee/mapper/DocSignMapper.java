package com.yxt.jhonelee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yxt.jhonelee.model.Docsignin;
/**
 * 
 * @author JhoneLee
 *
 */
public interface DocSignMapper {
	//查出对应id的医生的签到记录list
	public List<Docsignin> findAllDocSign( @Param(value="id")int id, @Param(value="timeInt")int timeInt);
}
