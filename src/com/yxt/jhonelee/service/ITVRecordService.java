package com.yxt.jhonelee.service;

import com.yxt.jhonelee.model.ITVRecord;

public interface ITVRecordService {

	public ITVRecord SelectAllRecord(int id);
	public Integer InsertRecord(ITVRecord itvRecord);
}
