package com.yxt.jhonelee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxt.jhonelee.mapper.DocSignMapper;
import com.yxt.jhonelee.model.Docsignin;
import com.yxt.jhonelee.service.DocSignService;

@Service
@Transactional
public class DocSignServiceImpl implements DocSignService {

	@Resource
	private DocSignMapper mapper;
	
	@Override
	public List<Docsignin> findAllDocSign(int id) {
		// TODO Auto-generated method stub
		return mapper.findAllDocSign(id);
	}

}
