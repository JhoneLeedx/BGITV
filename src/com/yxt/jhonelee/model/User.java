package com.yxt.jhonelee.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author JhoneLee
 * 用户类
 */

public class User implements Serializable{
	
	private static final long serialVersionUID = -8233973025341449488L;
	private int mId;//用户预约表主键ID
	 private String mToken;//登录微信唯一token
     private String mItvToken;//Itv唯一token
	 private int mUserId;//用户id
	 private String mUserName;//用户名字
	 private String mUserPhone;//用户电话
	 private int mDocId;//绑定医生id
	 private int mIsSign;//是否签约
	 private int mRegState;//预约状态 1-预约成功  2-通话完成 3-用户取消
	 private Date mRegTime;//预约时间
	 private Date  mUpdateTime;//最后一次更新时间
	 private int mScanCount;//扫码次数
	 private ITVRecord mItvRecord;//
	 private Doctor mDoctor;
	 
	 private Long mSu;//当前签到总数
	 
     public Long getmSu() {
		return mSu;
	}
	public void setmSu(Long mSu) {
		this.mSu = mSu;
	}
	
	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmToken() {
		return mToken;
	}
	public void setmToken(String mToken) {
		this.mToken = mToken;
	}
	public String getmItvToken() {
		return mItvToken;
	}
	public void setmItvToken(String mItvToken) {
		this.mItvToken = mItvToken;
	}
	public int getmUserId() {
		return mUserId;
	}
	public void setmUserId(int mUserId) {
		this.mUserId = mUserId;
	}
	public String getmUserName() {
		return mUserName;
	}
	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}
	public String getmUserPhone() {
		return mUserPhone;
	}
	public void setmUserPhone(String mUserPhone) {
		this.mUserPhone = mUserPhone;
	}
	public int getmDocId() {
		return mDocId;
	}
	public void setmDocId(int mDocId) {
		this.mDocId = mDocId;
	}
	public int getmIsSign() {
		return mIsSign;
	}
	public void setmIsSign(int mIsSign) {
		this.mIsSign = mIsSign;
	}
	public int getmRegState() {
		return mRegState;
	}
	public void setmRegState(int mRegState) {
		this.mRegState = mRegState;
	}
	public Date getmRegTime() {
		return mRegTime;
	}
	public void setmRegTime(Date mRegTime) {
		
		this.mRegTime = mRegTime;
	}
	public Date getmUpdateTime() {
		return mUpdateTime;
	}
	public void setmUpdateTime(Date mUpdateTime) {
		this.mUpdateTime = mUpdateTime;
	}
	public int getmScanCount() {
		return mScanCount;
	}
	public void setmScanCount(int mScanCount) {
		this.mScanCount = mScanCount;
	}
	public ITVRecord getmItvRecord() {
		return mItvRecord;
	}
	public void setmItvRecord(ITVRecord mItvRecord) {
		this.mItvRecord = mItvRecord;
	}
	public Doctor getmDoctor() {
		return mDoctor;
	}
	public void setmDoctor(Doctor mDoctor) {
		this.mDoctor = mDoctor;
	}
	 
	
}
