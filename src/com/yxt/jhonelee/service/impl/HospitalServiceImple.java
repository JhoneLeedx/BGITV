package com.yxt.jhonelee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.HospitalMapper;
import com.yxt.jhonelee.model.Hospital;
import com.yxt.jhonelee.service.HospitalService;

@Transactional
@Service
public class HospitalServiceImple implements HospitalService{

	
	@Resource
	private HospitalMapper mapper;
	@Override
	public List<Hospital> SelectHospital(int addressId) {
		// TODO Auto-generated method stub
		return mapper.SelectHospital(addressId);
	}

}
