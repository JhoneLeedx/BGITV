package com.yxt.jhonelee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxt.jhonelee.model.Admin;
import com.yxt.jhonelee.model.Docsignin;
import com.yxt.jhonelee.service.HealthSignService;

@Controller
public class HealthSignController {

	@Autowired
	private HealthSignService service;
	
	@RequestMapping("/healthUserSign")
	public String HealthUserSign(HttpServletRequest request){
		
		String mNum = request.getParameter("num");
		int num = 0;
		if(mNum!=null){
			num  = Integer.parseInt(mNum.trim());
		}
		List<Docsignin> list = service.HealthUserSignCount(num);
		request.setAttribute("list", list);
		
		return "healthusersign";
	}
	@RequestMapping("/healthDocSign")
	public String HealthDocSign(HttpServletRequest request,HttpSession session){
		
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin!=null){
			String mNum = request.getParameter("num");
			int num = 0;
			if(mNum!=null){
				num  = Integer.parseInt(mNum.trim());
			}
			List<Docsignin> list = service.HealthDocSignCount(num, admin.getmPid());
			request.setAttribute("list", list);
		}
		
		
		return "healthdocsign";
	}
}
