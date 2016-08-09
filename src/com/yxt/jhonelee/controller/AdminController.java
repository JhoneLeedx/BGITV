package com.yxt.jhonelee.controller;

import javax.servlet.http.HttpServletRequest;

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

	private AdminService adminService;
	
	@RequestMapping("/showRecord")
	public String SelectAllRecord(HttpServletRequest request){
		String sid = request.getParameter("id");
		int id = 0;
		if(sid!=null){
			id = Integer.parseInt(sid);
		}
		
		ITVRecord itvRecord = adminService.SelectAllRecord(id);
		request.setAttribute("itvRecord", itvRecord);
		
		return null;
	}
	
}
