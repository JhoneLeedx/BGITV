package com.yxt.jhonelee.mapper;

import java.util.List;

import com.yxt.jhonelee.model.Hospital;

/**
 * 
 * @author JhoneLee 与数据库hospital表对接的接口
 */
public interface HospitalMapper {

	// 查出对应addressID下的所有医院
	public List<Hospital> SelectHospital(int addressId);

	public List<Hospital> SelectAllHospital(String mCodeValue);

}
