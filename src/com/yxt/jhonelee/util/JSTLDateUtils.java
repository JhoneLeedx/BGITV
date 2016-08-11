package com.yxt.jhonelee.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 用于页面jstl时间格式化 //自定义jstl时间格式化标签
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
    public void setParttern(String parttern ) {
        this.parttern =  parttern ;
    }
    public int doStartTag() throws JspException{
        String vv = String.valueOf(value);  
        long time = Long.valueOf(vv);  
        Calendar c = Calendar.getInstance();  
        c.setTimeInMillis(time);  
        SimpleDateFormat dateformat =new SimpleDateFormat(parttern);  
        String s = dateformat.format(c.getTime());  
        try {  
            pageContext.getOut().write(s);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return super.doStartTag();
    }
    public static void main(String[] args) {
    	
    	Date now = new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
    	
    	Date userdate;
		try {
			userdate = formatter.parse("2016-08-11 15:48:30");
		
    	long a = now.getTime()-userdate.getTime();
    	
         long time = Long.valueOf(a);  
            Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("GMT+0"));
            c.setTimeInMillis(time);  
            SimpleDateFormat dateformat =new SimpleDateFormat("dd HH:mm");  
            String s = dateformat.format(c.getTime());  
        System.out.println(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
