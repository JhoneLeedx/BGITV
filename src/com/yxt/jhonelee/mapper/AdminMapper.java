package com.yxt.jhonelee.mapper;

import com.yxt.jhonelee.model.ITVRecord;

public interface AdminMapper {

	public ITVRecord SelectAllRecord(int id);
	
	public boolean InsertRecord(ITVRecord itvRecord);
}
