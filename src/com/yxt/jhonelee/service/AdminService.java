package com.yxt.jhonelee.service;

import com.yxt.jhonelee.model.ITVRecord;

public interface AdminService {

	public ITVRecord SelectAllRecord(int id);
	public boolean InsertRecord(ITVRecord itvRecord);
}
