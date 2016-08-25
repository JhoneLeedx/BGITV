package com.yxt.jhonelee.model;

/**
 * 
 * @author JhoneLee
 *医生类
 */
public class Doctor {

	private int mId;

	private String mDocPhone;//医生电话

	private String mDocName;//医生名称
	private String mIdCard;//身份证号

	
    public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmDocPhone() {
		return mDocPhone;
	}
	public void setmDocPhone(String mDocPhone) {
		this.mDocPhone = mDocPhone;
	}
	public String getmIdCard() {
		return mIdCard;
	}
	public void setmIdCard(String mIdCard) {
		this.mIdCard = mIdCard;
	}
	public String getmDocName() {
		return mDocName;
	}
	public void setmDocName(String mDocName) {
		this.mDocName = mDocName;
	}
	
}
