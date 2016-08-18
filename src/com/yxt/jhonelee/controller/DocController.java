package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yxt.jhonelee.model.DocDetail;
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
	@RequestMapping("/findDoc")
	public void findAllUser(HttpServletRequest request,PrintWriter out) {

		String hospitalId = request.getParameter("hospitalId");
		if(hospitalId!=null){
			int id = Integer.parseInt(hospitalId);
			List<DocDetail> doclists = doctorService.findAllDoc(id);
			if(doclists.size()>0){
				Gson gson = new Gson();
				String json = gson.toJson(doclists);
				out.write(json);
			}else{
				out.write("");
			}
		}
	}

}
