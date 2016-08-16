package com.yxt.jhonelee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxt.jhonelee.model.Admin;
import com.yxt.jhonelee.model.Doctor;
import com.yxt.jhonelee.service.DoctorService;
/**
 * 
 * @author JhoneLee
 * @category医生控制器
 * {@linkplain}医生数据和前台jsp交互
 */
@Controller
public class DocController {

	@Autowired
	private DoctorService doctorService;
    //首页展示医生列表
	@RequestMapping("/mains")
	public String findAllUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unused")
		Admin admin = (Admin)session.getAttribute("admin");
/*		switch (admin.getmLevel()) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;

		default:
			break;
		}*/
		
		List<Doctor> listDoc = doctorService.findAllDoc();
		request.setAttribute("listdoc", listDoc);
		return "/mains";
	}

}
