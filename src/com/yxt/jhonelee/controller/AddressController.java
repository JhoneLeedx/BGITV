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
import com.yxt.jhonelee.model.Hospital;
import com.yxt.jhonelee.service.AddressService;
import com.yxt.jhonelee.service.HospitalService;

/**
 * 
 * @author JhoneLee 管理地址的控制器
 */

@Controller
public class AddressController {

	@Autowired
	private AddressService service;

	@Autowired
	private HospitalService Hservice;

	/**
	 * 
	 * @param request
	 * @return 登录成功返回首页，极其显示的数据（地址或者有医院就显示医院）
	 */
	@RequestMapping("/main")
	public String SelectAddress(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin != null) {
			List<Hospital> lHospitals = Hservice.SelectAllHospital(admin.getmPid());
			request.setAttribute("listHospitals", lHospitals);
		}

		return "/main";
	}

	/**
	 * 
	 * @param request
	 * @param out
	 *            查询下一级别的地址返回的数据类型（json）
	 * 
	 */
	@RequestMapping("/findNext")
	public void findNext(HttpServletRequest request, PrintWriter out) {

		String mpid = request.getParameter("pid");
		List<Address> lists = service.SelectAddress(mpid);
		Gson gson = new Gson();
		String json = gson.toJson(lists);
		out.write(json);
	}
}
