package com.yxt.jhonelee.model;

import java.io.Serializable;

/**
 * 
 * @author JhoneLee
 * @category reason类
 *
 */
public class ITVRecord implements Serializable{
	
	private static final long serialVersionUID = 3833603392928185515L;
	private int mAdminId;
	private int mId;
	private int mRegistId;
	private String mDocReason;
	private String mUserReason;
	private int mHandle;
	private Admin mAdmin;
	

	public int getmAdminId() {
		return mAdminId;
	}

	public void setmAdminId(int mAdminId) {
		this.mAdminId = mAdminId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int getmRegistId() {
		return mRegistId;
	}

	public void setmRegistId(int mRegistId) {
		this.mRegistId = mRegistId;
	}
	public int getmHandle() {
		return mHandle;
	}

	public void setmHandle(int mHandle) {
		this.mHandle = mHandle;
	}

	public String getmDocReason() {
		return mDocReason;
	}

	public void setmDocReason(String mDocReason) {
		this.mDocReason = mDocReason;
	}

	public String getmUserReason() {
		return mUserReason;
	}

	public void setmUserReason(String mUserReason) {
		this.mUserReason = mUserReason;
	}

	public Admin getmAdmin() {
		return mAdmin;
	}

	public void setmAdmin(Admin mAdmin) {
		this.mAdmin = mAdmin;
	}

}
