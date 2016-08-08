package com.yxt.jhonelee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/main")
	public String findAllUser(HttpServletRequest request) {
		List<Doctor> listDoc = doctorService.findAllDoc();
		request.setAttribute("listdoc", listDoc);
		return "/main";
	}

}
