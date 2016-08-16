package com.yxt.jhonelee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.AddressMapper;
import com.yxt.jhonelee.model.Address;
import com.yxt.jhonelee.service.AddressService;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Resource
	private AddressMapper mapper;
	
	@Override
	public List<Address> SelectAddress(String pid) {
		// TODO Auto-generated method stub
		return mapper.SelectAddress(pid);
	}

}
