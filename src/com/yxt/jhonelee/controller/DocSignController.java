package com.yxt.jhonelee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public String findAllDocSign(HttpServletRequest request){
		String mId = request.getParameter("id");
		if(mId!=null){
			int id = Integer.parseInt(mId.trim());
			List<Docsignin> list = service.findAllDocSign(id);
			request.setAttribute("list", list);
			return "/doctorsignin";	
		}else{
			return "/404";
		}
	}
	
}
