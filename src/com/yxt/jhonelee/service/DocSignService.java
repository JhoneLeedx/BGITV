package com.yxt.jhonelee.service;

import java.util.List;

import com.yxt.jhonelee.model.Docsignin;

public interface DocSignService {
	public List<Docsignin> findAllDocSign(int id,int timeInt);
}
