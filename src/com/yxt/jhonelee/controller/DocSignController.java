package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
	
	/**
	 * 
	 * @param request
	 * @param out 把医生扫二维码签到的list存到session中
	 */
	
	@RequestMapping("/docsign")
	public void findAllDocSign(HttpServletRequest request,PrintWriter out){
		HttpSession session = request.getSession();
		session.removeAttribute("signtime");
		session.removeAttribute("counts");
		String mId = request.getParameter("id");
		if(mId!=null){
			int id = Integer.parseInt(mId.trim());
			List<Docsignin> list = service.findAllDocSign(id);
			
			if(list.size()>0){
				StringBuilder sb = new StringBuilder();
				StringBuilder sbc = new StringBuilder();
				for(int i=0;i<list.size();i++){
					sb.append("'"+new SimpleDateFormat("MM-dd").format(list.get(i).getmSignTime())+"'"+",");
					sbc.append(list.get(i).getmCu()+",");
				}
				String signtime = sb.toString().substring(0,sb.toString().length()-1);
				String counts = sbc.toString().substring(0,sbc.toString().length()-1);
				System.out.println(signtime);
				System.out.println(counts);
				session.setAttribute("signtime", signtime);
				session.setAttribute("counts", counts);
			}
			out.write("成功");
		}
	}
	
}
