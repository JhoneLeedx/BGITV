package com.yxt.jhonelee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxt.jhonelee.model.Admin;
import com.yxt.jhonelee.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adService;

	// 登录界面
	/**
	 * 
	 * @param request
	 * @param out 登录验证
	 * @throws IOException
	 */

	@RequestMapping("/login")
	public void login(HttpServletRequest request,PrintWriter out) throws IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("adminName");
		String password = request.getParameter("password");
		List<Admin> list = adService.SelectAllAdmin(username);
		HttpSession session = request.getSession();
		String r = null;
		if (list.size() > 0) {
			for (Admin admin : list) {
				if (password.equals(admin.getmAdminPass())) {
					if(admin.getmSysType()==1){
						session.setAttribute("admin", admin);
						r = "登录成功";
					}else{
						r = "该管理员不是协同服务的，请联系超级管理员";
					}
					
				} else {
					r = "密码错误";
				}
			}
		}else{
			r="用户名不存在";
		}
		out.write(r);
	}
	/**
	 * 
	 * @param request
	 * @return 退出管理员登录的状态
 	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		return "/logins";
	}
}
