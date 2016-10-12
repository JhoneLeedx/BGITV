package com.yxt.jhonelee.model;

import java.io.Serializable;
import java.util.Date;

public class HomeBar implements Serializable{
   
	private static final long serialVersionUID = -7211161317457410890L;
	private int mDocId;
	private String mUserName;
	private Date mRegTime;
	private int mCot;
	
	public int getmDocId() {
		return mDocId;
	}
	public void setmDocId(int mDocId) {
		this.mDocId = mDocId;
	}
	public String getmUserName() {
		return mUserName;
	}
	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}
	public Date getmRegTime() {
		return mRegTime;
	}
	public void setmRegTime(Date mRegTime) {
		this.mRegTime = mRegTime;
	}
	public int getmCot() {
		return mCot;
	}
	public void setmCot(int mCot) {
		this.mCot = mCot;
	}
}
