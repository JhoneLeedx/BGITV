package com.yxt.jhonelee.service;

import java.util.List;

import com.yxt.jhonelee.model.DocDetail;

public interface DoctorService {

	List<DocDetail> findAllDoc(int hospitalId);
}
