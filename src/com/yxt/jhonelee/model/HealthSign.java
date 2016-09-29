package com.yxt.jhonelee.model;

import java.io.Serializable;
import java.util.Date;

public class HealthSign implements Serializable{

	 private static final long serialVersionUID = 1L;
	 private int mId;//地区id
	 private String mPlaceName;//地区名称
	 private String mHospitalName;//医院名称
	 private int mDocId;//医生id
	 private int mUserId;//用户id
	 private String mDocName;//医生名称
	 private String mUserName;//用户名称
	 private Date mSignInTime;//健康档案最新扫码时间
	 private int mCu;//扫码总数
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmPlaceName() {
		return mPlaceName;
	}
	public void setmPlaceName(String mPlaceName) {
		this.mPlaceName = mPlaceName;
	}
	public String getmHospitalName() {
		return mHospitalName;
	}
	public void setmHospitalName(String mHospitalName) {
		this.mHospitalName = mHospitalName;
	}
	public int getmDocId() {
		return mDocId;
	}
	public void setmDocId(int mDocId) {
		this.mDocId = mDocId;
	}
	public int getmUserId() {
		return mUserId;
	}
	public void setmUserId(int mUserId) {
		this.mUserId = mUserId;
	}
	public String getmDocName() {
		return mDocName;
	}
	public void setmDocName(String mDocName) {
		this.mDocName = mDocName;
	}
	public String getmUserName() {
		return mUserName;
	}
	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}
	public Date getmSignInTime() {
		return mSignInTime;
	}
	public void setmSignInTime(Date mSignInTime) {
		this.mSignInTime = mSignInTime;
	}
	public int getmCu() {
		return mCu;
	}
	public void setmCu(int mCu) {
		this.mCu = mCu;
	}
}
