package com.yxt.jhonelee.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 用于页面jstl时间格式化 //自定义jstl时间格式化标签
 * 
 * @author JhoneLee
 *
 */
public class JSTLDateUtils extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3354015192721342312L;

	private String value;
	private String parttern;

	public void setValue(String value) {
		this.value = value;
	}

	public void setParttern(String parttern) {
		this.parttern = parttern;
	}

	public int doStartTag() throws JspException {
		String vv = String.valueOf(value);
		long time = Long.valueOf(vv);
		long days = time / (1000 * 60 * 60 * 24);
        long hours = (time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (time % (1000 * 60 * 60)) / (1000 * 60);
		@SuppressWarnings("unused")
		SimpleDateFormat dateformat = new SimpleDateFormat(parttern);
		String s = null;
		if (days < 1) {
			s = hours + "小时" + minutes + "分";
		} else {
			s = days + "天" + hours + "小时" + minutes + "分";
		}
		try {
			pageContext.getOut().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public static void main(String[] args) {
		try {
			Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-08-03 14:39:54");
			Date now = new Date();
			long l = now.getTime() - time.getTime();
			long days = l / (1000 * 60 * 60 * 24);
			long hours = (l % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
			long minutes = (l % (1000 * 60 * 60)) / (1000 * 60);
			// long seconds = (l % (1000 * 60)) / 1000;
			/*
			 * long hours = (l-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60); long
			 * minutes = (l-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 *
			 * 60))/(1000* 60);
			 */

			String s = days + "天" + hours + "小时" + minutes + "分";
			System.out.println(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
