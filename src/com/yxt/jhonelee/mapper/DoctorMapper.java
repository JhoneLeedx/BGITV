package com.yxt.jhonelee.mapper;

import java.util.List;


import com.yxt.jhonelee.model.DocDetail;

/**
 * 
 * @author JhoneLee
 *
 */
public interface DoctorMapper {
	//找到某个医院下所有医生信息
	public List<DocDetail> findAllDoc(int hospitalId);
}
