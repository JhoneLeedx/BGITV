package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxt.jhonelee.model.ITVRecord;
import com.yxt.jhonelee.service.AdminService;

/**
 * 
 * @author JhoneLee
 * @category 管理员控制器
 *
 */
@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("/showRecord")
	public String SelectAllRecord(HttpServletRequest request) {
		String sid = request.getParameter("id");
		int id = 0;
		if (sid != null) {
			id = Integer.parseInt(sid);
		}

		ITVRecord itvRecord = adminService.SelectAllRecord(id);
		request.setAttribute("itvRecord", itvRecord);

		
		return null;
	}

	//插入数据到数据库当中
	
	@RequestMapping("/insertReason")
	public void insertReason(HttpServletRequest request, PrintWriter out) {
		try {
			request.setCharacterEncoding("utf-8");
			String shandle = request.getParameter("handle");
			String sadminid =request.getParameter("adminid");
			String sregistid = request.getParameter("registid");
			//String sreason = request.getParameter("reason");
			ITVRecord itvRecord = new ITVRecord();
			if(sadminid!=null){
				itvRecord.setmAdminId(Integer.parseInt(sadminid));
			}
			if(shandle!=null){
				itvRecord.setmHandle(Integer.parseInt(shandle));
			}
			if(sregistid!=null){
				itvRecord.setmRegistId(Integer.parseInt(sregistid));
			}
			
			if (adminService.InsertRecord(itvRecord)!=null) {
				out.write("添加成功");
			}else{
				out.write("添加失败");
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
