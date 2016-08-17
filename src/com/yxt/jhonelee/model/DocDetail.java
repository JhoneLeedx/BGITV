package com.yxt.jhonelee.model;

public class DocDetail {

	private int mDocId;
	private String mName;
	private int mHospitalId;
	private Doctor mDoctor;
	
	public int getmDocId() {
		return mDocId;
	}
	public void setmDocId(int mDocId) {
		this.mDocId = mDocId;
	}
	public int getmHospitalId() {
		return mHospitalId;
	}
	public void setmHospitalId(int mHospitalId) {
		this.mHospitalId = mHospitalId;
	}
	public Doctor getmDoctor() {
		return mDoctor;
	}
	public void setmDoctor(Doctor mDoctor) {
		this.mDoctor = mDoctor;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
}
