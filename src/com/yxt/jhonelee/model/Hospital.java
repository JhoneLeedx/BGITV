package com.yxt.jhonelee.model;

import java.io.Serializable;

public class Hospital implements Serializable{

	private static final long serialVersionUID = -1568993857146732853L;
	private int mId;
	private String mName;
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
}
