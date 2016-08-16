package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yxt.jhonelee.model.Address;
import com.yxt.jhonelee.model.Admin;
import com.yxt.jhonelee.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	private AddressService service;
	
	@RequestMapping("/main")
	public String SelectAddress(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin!=null){
			List<Address> lists = service.SelectAddress(admin.getmPid());
			request.setAttribute("listAddress", lists);
		}
		return "/main";
	}
	@RequestMapping("/findNext")
	public void findNext(HttpServletRequest request,PrintWriter out){

		String mpid = request.getParameter("pid");
		List<Address> lists = service.SelectAddress(mpid);
		Gson gson = new Gson();
		String json = gson.toJson(lists);
		out.write(json);
	}
	
}
