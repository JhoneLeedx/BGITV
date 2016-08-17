package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yxt.jhonelee.model.Hospital;
import com.yxt.jhonelee.service.HospitalService;

@Controller
public class HospitalController {
	@Autowired
	private HospitalService service;
	
	
	@RequestMapping("/findHospital")
	public void SelectHos(HttpServletRequest request,PrintWriter out){
		String saddressid = request.getParameter("addressId");
		if(saddressid!=null){
			int addressId = Integer.parseInt(saddressid);
			List<Hospital> hospitals = service.SelectHospital(addressId);
			if(hospitals.size()>0){
				Gson gson = new Gson();
				String json = gson.toJson(hospitals);
				out.write(json);
			}
		}
		
	}
	
}
