package com.yxt.jhonelee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yxt.jhonelee.model.DocDetail;


public interface DoctorMapper {

	public List<DocDetail> findAllDoc(int hospitalId);//找到某个医院下所有医生信息
	public List<DocDetail> findAllDoctor(@Param(value = "list")List<Integer> list);//找到管理员下所有医生信息
}
