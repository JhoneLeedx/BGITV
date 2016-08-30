package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxt.jhonelee.model.Admin;
import com.yxt.jhonelee.model.User;
import com.yxt.jhonelee.service.UserService;
import com.yxt.jhonelee.util.Page;

/**
 * 
 * @author JhoneLee 用户的控制器实现后台数据和jsp页面的交互
 */

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @param request
	 * @return 显示每个医生最近的预约的用户信息
	 */
	@RequestMapping("/home")
	public String findUserBydocId(HttpServletRequest request) {
		
		Admin admin =(Admin) request.getSession().getAttribute("admin");
		
		
		String stimeInt = request.getParameter("timeInt");
		int timeInt = 0;
		if (stimeInt != null) {
			timeInt = Integer.parseInt(stimeInt);
		}
		String pageNow = request.getParameter("pageNow");
		Page page = null;
		int totalcount = userService.getHomeCount(timeInt,admin.getmPid());
		if (pageNow != null) {
			page = new Page(totalcount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalcount, 1);
		}
		List<User> listUser = userService.selectUserHomeBypage(page.getStartPos(), page.getPageSize(), timeInt,admin.getmPid());
		request.setAttribute("listUser", listUser);
		request.setAttribute("timeInt", timeInt);
		request.setAttribute("page", page);
		return "/home";
	}
	/**
	 * 
	 * @param request
	 * @return  分页显示医生id的签约用户信息
	 */
	@RequestMapping("/detail")
	public String selectUserByPage(HttpServletRequest request) {
		String stimeInt = request.getParameter("timeInt");
		String docName = request.getParameter("docName");
		String id = request.getParameter("id");
		int docId = Integer.parseInt(id);
		int timeInt = 0;
		if (stimeInt != null) {
			timeInt = Integer.parseInt(stimeInt);
		}
		String pageNow = request.getParameter("pageNow");
		Page page = null;
		int totalcount = 0;
		List<User> listUser = null;
		totalcount = userService.getUserCount(docId, timeInt);
		if (pageNow != null) {
			page = new Page(totalcount, Integer.parseInt(pageNow));

		} else {
			page = new Page(totalcount, 1);
		}
		listUser = userService.selectUserByPage(docId, page.getStartPos(), page.getPageSize(), timeInt);
		request.setAttribute("timeInt", timeInt);
		request.setAttribute("docName", docName);
		request.setAttribute("id", docId);
		request.setAttribute("listUser", listUser);
		request.setAttribute("page", page);
		return "/detail";
	}

	/**
	 * 
	 * @param request
	 * @param out 返回一个选择的时间点（今天:0;昨天:1;前天:2;所有时间:3;）
	 */
	@RequestMapping("/timeDetail")
	public void selectPage(HttpServletRequest request, PrintWriter out) {
		String stimeInt = request.getParameter("timeInt");
		out.write(stimeInt);
	}
}
