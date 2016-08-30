package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxt.jhonelee.model.Docsignin;
import com.yxt.jhonelee.service.DocSignService;

/**
 * 
 * @author JhoneLee
 *
 */
@Controller
public class DocSignController {

	@Autowired
	private DocSignService service;
	@RequestMapping("/docsign")
	public void findAllDocSign(HttpServletRequest request,PrintWriter out){
		HttpSession session = request.getSession();
		session.removeAttribute("list");
		String mId = request.getParameter("id");
		String stimeInt = request.getParameter("timeInt");
		int timeInt = 0;
		if (stimeInt != null) {
			timeInt = Integer.parseInt(stimeInt);
		}
		if(mId!=null){
			int id = Integer.parseInt(mId.trim());
			List<Docsignin> list = service.findAllDocSign(id,timeInt);
			request.getSession().setAttribute("list", list);
			out.write("成功");
		}
	}
	
}
