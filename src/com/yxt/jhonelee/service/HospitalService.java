package com.yxt.jhonelee.service;

import java.util.List;

import com.yxt.jhonelee.model.Hospital;

public interface HospitalService {
	
	public List<Hospital> SelectHospital(int addressId);

	public List<Hospital> SelectAllHospital(String mCodeValue);
}
