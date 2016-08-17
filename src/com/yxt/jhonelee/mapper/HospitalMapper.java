package com.yxt.jhonelee.mapper;

import java.util.List;

import com.yxt.jhonelee.model.Hospital;

public interface HospitalMapper {
	public List<Hospital> SelectHospital(int addressId);
}
