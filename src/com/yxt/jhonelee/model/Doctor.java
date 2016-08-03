package com.yxt.jhonelee.model;

import java.sql.Date;
/**
 * 
 * @author JhoneLee
 *医生类
 */
public class Doctor {

	private int mId;
	private int mRegSourceId;//注册来源ID
	private int mDocTypeId;//医生类型ID
	private int mDocLevelId;//医生级别ID
	private String mZwName;//职务
	private int mTitleId;//职称ID
	private String mDocName;//医生登录帐号名
	private String mDocPhone;//医生电话
	private String mDocPass;//医生登录医总管后台密码
	private String mWechatId;//微信ID
	private String mUnionId;
	private int mIsvalid;//是否审核0-未审核1-已审核
	private String mIdCard;//身份证号
	private int mState;//状态 0-正常1-异常
	private Date mRegDate;//注册时间
	private String mRemark;//
	private String mItvNum;//医生 ITV 帐号
	private String mZxzNum;//执行证号
    public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getmRegSourceId() {
		return mRegSourceId;
	}
	public void setmRegSourceId(int mRegSourceId) {
		this.mRegSourceId = mRegSourceId;
	}
	public int getmDocTypeId() {
		return mDocTypeId;
	}
	public void setmDocTypeId(int mDocTypeId) {
		this.mDocTypeId = mDocTypeId;
	}
	public int getmDocLevelId() {
		return mDocLevelId;
	}
	public void setmDocLevelId(int mDocLevelId) {
		this.mDocLevelId = mDocLevelId;
	}
	public String getmZwName() {
		return mZwName;
	}
	public void setmZwName(String mZwName) {
		this.mZwName = mZwName;
	}
	public int getmTitleId() {
		return mTitleId;
	}
	public void setmTitleId(int mTitleId) {
		this.mTitleId = mTitleId;
	}
	public String getmDocName() {
		return mDocName;
	}
	public void setmDocName(String mDocName) {
		this.mDocName = mDocName;
	}
	public String getmDocPhone() {
		return mDocPhone;
	}
	public void setmDocPhone(String mDocPhone) {
		this.mDocPhone = mDocPhone;
	}
	public String getmDocPass() {
		return mDocPass;
	}
	public void setmDocPass(String mDocPass) {
		this.mDocPass = mDocPass;
	}
	public String getmWechatId() {
		return mWechatId;
	}
	public void setmWechatId(String mWechatId) {
		this.mWechatId = mWechatId;
	}
	public String getmUnionId() {
		return mUnionId;
	}
	public void setmUnionId(String mUnionId) {
		this.mUnionId = mUnionId;
	}
	public int getmIsvalid() {
		return mIsvalid;
	}
	public void setmIsvalid(int mIsvalid) {
		this.mIsvalid = mIsvalid;
	}
	public String getmIdCard() {
		return mIdCard;
	}
	public void setmIdCard(String mIdCard) {
		this.mIdCard = mIdCard;
	}
	public int getmState() {
		return mState;
	}
	public void setmState(int mState) {
		this.mState = mState;
	}
	public Date getmRegDate() {
		return mRegDate;
	}
	public void setmRegDate(Date mRegDate) {
		this.mRegDate = mRegDate;
	}
	public String getmRemark() {
		return mRemark;
	}
	public void setmRemark(String mRemark) {
		this.mRemark = mRemark;
	}
	public String getmItvNum() {
		return mItvNum;
	}
	public void setmItvNum(String mItvNum) {
		this.mItvNum = mItvNum;
	}
	public String getmZxzNum() {
		return mZxzNum;
	}
	public void setmZxzNum(String mZxzNum) {
		this.mZxzNum = mZxzNum;
	}

	
}
