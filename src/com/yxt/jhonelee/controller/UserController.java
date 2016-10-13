package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxt.jhonelee.model.Admin;
import com.yxt.jhonelee.model.HomeBar;
import com.yxt.jhonelee.model.User;
import com.yxt.jhonelee.service.HomeBarService;
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
	@Autowired
	private HomeBarService homeBarService;
	/**
	 * 
	 * @param request
	 * @return 显示每个医生最近的预约的用户信息
	 */
	@RequestMapping("/home")
	public String findUserBydocId(HttpServletRequest request) {
		
		Admin admin =(Admin) request.getSession().getAttribute("admin");
		String time = request.getParameter("time");
		int mTime = 0;
		if(time!=null){
			mTime = Integer.parseInt(time.trim());
		}
		
		List<HomeBar> list =  homeBarService.HomeSum(admin.getmPid(),mTime);
		List<HomeBar> list1 =  homeBarService.HomeSumCount(admin.getmPid(),1,mTime);
		List<HomeBar> list2 =  homeBarService.HomeSumCount(admin.getmPid(),2,mTime);
		List<HomeBar> list3 =  homeBarService.HomeSumCount(admin.getmPid(),3,mTime);
		if(list.size()>0){
			StringBuilder sb = new StringBuilder();
			StringBuilder sbc = new StringBuilder();
			for(int i=0;i<list.size();i++){
				sb.append("'"+new SimpleDateFormat("MM-dd").format(list.get(i).getmRegTime())+"'"+",");
				sbc.append(list.get(i).getmCot()+",");
			}
			String signtime = sb.toString().substring(0,sb.toString().length()-1);
			String counts = sbc.toString().substring(0,sbc.toString().length()-1);
			System.out.println(signtime);
			System.out.println(counts);
			request.setAttribute("signtime", signtime);
			request.setAttribute("counts", counts);
		}
		
		if(list1.size()>0){
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sbc1 = new StringBuilder();
			for(int i=0;i<list1.size();i++){
				sb1.append("'"+new SimpleDateFormat("MM-dd").format(list1.get(i).getmRegTime())+"'"+",");
				sbc1.append(list1.get(i).getmCot()+",");
			}
			String signtime1 = sb1.toString().substring(0,sb1.toString().length()-1);
			String counts1 = sbc1.toString().substring(0,sbc1.toString().length()-1);
			System.out.println(signtime1);
			System.out.println(counts1);
			request.setAttribute("signtime1", signtime1);
			request.setAttribute("counts1", counts1);
		}
		
		
		if(list2.size()>0){
			StringBuilder sb = new StringBuilder();
			StringBuilder sbc= new StringBuilder();
			for(int i=0;i<list2.size();i++){
				sb.append("'"+new SimpleDateFormat("MM-dd").format(list2.get(i).getmRegTime())+"'"+",");
				sbc.append(list2.get(i).getmCot()+",");
			}
			String signtime = sb.toString().substring(0,sb.toString().length()-1);
			String counts = sbc.toString().substring(0,sbc.toString().length()-1);
			System.out.println(signtime);
			System.out.println(counts);
			request.setAttribute("signtime2", signtime);
			request.setAttribute("counts2", counts);
		}
		if(list3.size()>0){
			StringBuilder sb = new StringBuilder();
			StringBuilder sbc= new StringBuilder();
			for(int i=0;i<list3.size();i++){
				sb.append("'"+new SimpleDateFormat("MM-dd").format(list3.get(i).getmRegTime())+"'"+",");
				sbc.append(list3.get(i).getmCot()+",");
			}
			String signtime = sb.toString().substring(0,sb.toString().length()-1);
			String counts = sbc.toString().substring(0,sbc.toString().length()-1);
			System.out.println(signtime);
			System.out.println(counts);
			request.setAttribute("signtime3", signtime);
			request.setAttribute("counts3", counts);
		}
		
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
	
	
	
	@RequestMapping("/userSign")
	public String userSign(HttpServletRequest request) {
		
		List<User> list = userService.UserSignSum();
		System.out.println(list);
		request.setAttribute("list", list);
		return "usersign";
	}
	
}
