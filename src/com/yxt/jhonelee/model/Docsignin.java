package com.yxt.jhonelee.model;

import java.util.Date;

public class Docsignin {

	private int mId;
	private int mKeyId;
	private Date mSignTime;
	private int mState;
	private String mToken;
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getmKeyId() {
		return mKeyId;
	}
	public void setmKeyId(int mKeyId) {
		this.mKeyId = mKeyId;
	}
	public Date getmSignTime() {
		return mSignTime;
	}
	public void setmSignTime(Date mSignTime) {
		this.mSignTime = mSignTime;
	}
	public int getmState() {
		return mState;
	}
	public void setmState(int mState) {
		this.mState = mState;
	}
	public String getmToken() {
		return mToken;
	}
	public void setmToken(String mToken) {
		this.mToken = mToken;
	}
	
	
}
