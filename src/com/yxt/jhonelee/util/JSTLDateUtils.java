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
		long hours = (time-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
		long minutes = (time-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
		SimpleDateFormat dateformat = new SimpleDateFormat(parttern);
		String s = days+"天"+hours+"小时"+minutes+"分";
		try {
			pageContext.getOut().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public static void main(String[] args) {

		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date userdate;
			userdate = formatter.parse("2016-08-11 15:48:30");
			long diff = now.getTime() - userdate.getTime();
			long days = diff / (1000 * 60 * 60 * 24);
			long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
			long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
			System.out.println(days+"天"+hours+"小时"+minutes+"分");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
