package com.yxt.jhonelee.service;

import java.util.List;

import com.yxt.jhonelee.model.DocDetail;

public interface DoctorService {

	List<DocDetail> findAllDoc(int hospitalId);
	public List<DocDetail> findAllDoctor(List<Integer> list);//找到管理员下所有医生信息
}
