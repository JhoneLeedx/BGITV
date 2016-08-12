package com.yxt.jhonelee.mapper;

import com.yxt.jhonelee.model.ITVRecord;

public interface ITVRecordMapper {

	public ITVRecord SelectAllRecord(int id);
	
	public Integer InsertRecord(ITVRecord itvRecord);
}
