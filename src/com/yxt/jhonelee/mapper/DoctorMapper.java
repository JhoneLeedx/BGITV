package com.yxt.jhonelee.mapper;

import java.util.List;

import com.yxt.jhonelee.model.DocDetail;


public interface DoctorMapper {

	List<DocDetail> findAllDoc(int hospitalId);//找到所有医生信息
}
