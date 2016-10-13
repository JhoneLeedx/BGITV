package com.yxt.jhonelee.model;

import java.io.Serializable;
import java.util.Date;

public class Docsignin implements Serializable{

	private static final long serialVersionUID = -8951218520487290690L;
	private int mId;
	private int mKeyId;
	private Date mSignTime;
	private int mState;
	private String mToken;
	private int mCu;  
	
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
	public int getmCu() {
		return mCu;
	}
	public void setmCu(int mCu) {
		this.mCu = mCu;
	}
	
}
