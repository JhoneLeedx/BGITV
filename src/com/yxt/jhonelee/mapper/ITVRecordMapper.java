package com.yxt.jhonelee.mapper;

import com.yxt.jhonelee.model.ITVRecord;
/**
 * 
 * @author JhoneLee
 *  与数据库ITV_RECORD表对接的接口
 */
public interface ITVRecordMapper {

	//通过id查出对应的record记录
	public ITVRecord SelectAllRecord(int id);
	//添加对应的record记录到数据库表中
	public Integer InsertRecord(ITVRecord itvRecord);
}
