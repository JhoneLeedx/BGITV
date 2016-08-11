package com.yxt.jhonelee.model;

/**
 * 
 * @author JhoneLee
 * @category 管理员类
 *
 */
public class ITVRecord {

	private int mAdminId;
	private int mId;
	private int mRegistId;
	private String mDocReason;
	private String mUserReason;
	private int mHandle;

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

}
