package com.yxt.jhonelee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.DoctorMapper;
import com.yxt.jhonelee.model.Doctor;
import com.yxt.jhonelee.service.DoctorService;

@Service
@Transactional
public class DocServiceImpl implements DoctorService {

	@Resource
	private DoctorMapper mapper ;
	@Override
	public List<Doctor> findAllDoc() {
		// TODO Auto-generated method stub
		return mapper.findAllDoc();
	}

}
