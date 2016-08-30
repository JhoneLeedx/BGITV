package com.yxt.jhonelee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yxt.jhonelee.model.Docsignin;

public interface DocSignMapper {

	public List<Docsignin> findAllDocSign( @Param(value="id")int id, @Param(value="timeInt")int timeInt);
}
