package com.yxt.jhonelee.model;

import java.io.Serializable;

/**
 * 
 * @author JhoneLee
 *  地址
 */
public class Address implements Serializable{


	private static final long serialVersionUID = 9124487212988044056L;
	private int mId;
	private String mCodevalue;
	private String mName;
	private String mRemark;
	private String mPid;
	private int mLevel;
	
	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmCodevalue() {
		return mCodevalue;
	}
	public void setmCodevalue(String mCodevalue) {
		this.mCodevalue = mCodevalue;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmRemark() {
		return mRemark;
	}
	public void setmRemark(String mRemark) {
		this.mRemark = mRemark;
	}
	public String getmPid() {
		return mPid;
	}
	public void setmPid(String mPid) {
		this.mPid = mPid;
	}
	public int getmLevel() {
		return mLevel;
	}
	public void setmLevel(int mLevel) {
		this.mLevel = mLevel;
	}
	
}
