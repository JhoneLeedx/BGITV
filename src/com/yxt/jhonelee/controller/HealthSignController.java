package com.yxt.jhonelee.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxt.jhonelee.model.Admin;
import com.yxt.jhonelee.model.HealthSign;
import com.yxt.jhonelee.service.HealthSignService;
import com.yxt.jhonelee.util.Page;

@Controller
public class HealthSignController {

	@Autowired
	private HealthSignService service;

	@RequestMapping("/healthUserSign")
	public String HealthUserSign(HttpServletRequest request, HttpSession session) {

		Admin admin = (Admin) session.getAttribute("admin");
		Page page = null;
		if (admin != null) {
			String mNum = request.getParameter("num");
			String pageNow = request.getParameter("pageNow");
			int num = 0;
			
			if (mNum != null) {
				num = Integer.parseInt(mNum.trim());
			}
			int count = service.UserSignCount(num, admin.getmPid());
			if(pageNow!=null){
				page = new Page(count, Integer.parseInt(pageNow.trim()));
			}else{
				page = new Page(count, 1);
			}
			List<HealthSign> list = service.HealthUserSignCount(num, admin.getmPid(),page.getStartPos(),page.getPageSize());
			if(list.size()>0){
				request.setAttribute("list", list);
				request.setAttribute("page", page);
				request.setAttribute("num", num);
				return "healthusersign";
			}else{
				return "healthusersign";
			}
			
		} else {
			return "404";
		}
	}

	@RequestMapping("/healthDocSign")
	public String HealthDocSign(HttpServletRequest request, HttpSession session) {

		Admin admin = (Admin) session.getAttribute("admin");
		Page page = null;
		if (admin != null) {
			String mNum = request.getParameter("num");
			String pageNow = request.getParameter("pageNow");
			int num = 0;
			
			if (mNum != null) {
				num = Integer.parseInt(mNum.trim());
			}
			int count = service.DocSignCount(num, admin.getmPid());
			
			if(pageNow!=null){
				page = new Page(count, Integer.parseInt(pageNow.trim()));
			}else{
				page = new Page(count, 1);
			}
			List<HealthSign> list = service.HealthDocSignCount(num, admin.getmPid(),page.getStartPos(),page.getPageSize());
			if(list.size()>0){
				request.setAttribute("list", list);
				request.setAttribute("page", page);
				request.setAttribute("num", num);
				return "healthdocsign";
			}else{
				return "healthdocsign";
			}
		} else {
			return "404";
		}

	}
	@RequestMapping("/healthNoUserSign")
	public String healthNoUesrSign(HttpServletRequest request){
		
		List<HealthSign> list = service.noUserSign();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sbc = new StringBuilder();
		for(int i=0;i<list.size();i++){
			sb.append("'"+new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getmSignInTime())+"'"+",");
			sbc.append(list.get(i).getmCu()+",");
		}
		String signtime = sb.toString().substring(0,sb.toString().length()-1);
		String counts = sbc.toString().substring(0,sbc.toString().length()-1);
		System.out.println(signtime);
		System.out.println(counts);
		request.setAttribute("signtime", signtime);
		request.setAttribute("counts", counts);
		return "nousersign";
		
	}
	
	@RequestMapping("/healthNoDocSign")
	public String healthUserSign(HttpServletRequest request){
		List<HealthSign> list = service.noDocSign();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbc = new StringBuilder();
		for(int i=0;i<list.size();i++){
			sb.append("'"+new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getmSignInTime())+"'"+",");
			sbc.append(list.get(i).getmCu()+",");
		}
		String signtime = sb.toString().substring(0,sb.toString().length()-1);
		String counts = sbc.toString().substring(0,sbc.toString().length()-1);
		System.out.println(signtime);
		System.out.println(counts);
		request.setAttribute("signtime", signtime);
		request.setAttribute("counts", counts);
		return "nodocsign";
	}
}
