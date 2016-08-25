package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxt.jhonelee.model.Address;
import com.yxt.jhonelee.model.Admin;
import com.yxt.jhonelee.model.DocDetail;
import com.yxt.jhonelee.model.Hospital;
import com.yxt.jhonelee.model.User;
import com.yxt.jhonelee.service.AddressService;
import com.yxt.jhonelee.service.DoctorService;
import com.yxt.jhonelee.service.HospitalService;
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
	
	// 显示详细的用户信息
	/*
	 * @RequestMapping("/detail") public String findAllUser(HttpServletRequest
	 * request) { String id = request.getParameter("id"); int docId =
	 * Integer.parseInt(id); List<User> listUser =
	 * userService.findAllUser(docId); request.setAttribute("listUser",
	 * listUser); return "/detail"; }
	 */
	// 显示每个医生最近的预约的用户信息
	@RequestMapping("/home")
	public String findUserBydocId(HttpServletRequest request) {
		
		List<Integer> list = getAddresss(request);
		String stimeInt = request.getParameter("timeInt");
		int timeInt = 0;
		if (stimeInt != null) {
			timeInt = Integer.parseInt(stimeInt);
		}
		String pageNow = request.getParameter("pageNow");
		Page page = null;
		int totalcount = userService.getHomeCount(timeInt,getDocIdList(getAllHospital(list)));
		if (pageNow != null) {
			page = new Page(totalcount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalcount, 1);
		}
		List<User> listUser = userService.selectUserHomeBypage(page.getStartPos(), page.getPageSize(), timeInt,getDocIdList(getAllHospital(list)));
		request.setAttribute("listUser", listUser);
		request.setAttribute("timeInt", timeInt);
		request.setAttribute("page", page);
		return "/home";
	}

	// 登录界面
	/*
	 * @RequestMapping("/login") public String login(HttpServletRequest request)
	 * throws IOException { String username = request.getParameter("username");
	 * String password = request.getParameter("password"); List<User> list =
	 * userService.findUserByName(username); HttpSession session =
	 * request.getSession(); int r = 0; if (list.size() > 0) { for (User user :
	 * list) { if (password.equals(user.getmUserPhone())) {
	 * session.setAttribute("user", user); r = 1; } else { r = 2; } } } if (r ==
	 * 1) { return "/main"; } return "/error";
	 * 
	 * }
	 */
	// 分页显示医生id的签约用户信息
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

	@RequestMapping("/timeDetail")
	public void selectPage(HttpServletRequest request, PrintWriter out) {
		String stimeInt = request.getParameter("timeInt");
		out.write(stimeInt);
	}
	private List<Integer> getAddresss(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin!=null){
			List<Integer> list =	getAddress(admin.getmPid());
			return list;
		}
		return null;
	}
	
	@Autowired
	private AddressService aservice;
	@Autowired
	private HospitalService hservice;
	@Autowired DoctorService dservice;
	
	/**
	 * 
	 * @param id
	 * @return 递归遍历数据库得到所有的addressID
	 */
	private List<Integer> getAddress(String id){
	
	List<Address> list = 	aservice.SelectAllAddress(id);
	List<Integer> intList = new ArrayList<Integer>();//得到所有的addressId
	if(list.size()>0){
		for(Address a:list){
			intList.add(a.getmId());
		}
	}
	return intList;
}
	/**
	 * 
	 * @param list
	 * @return所有医院的id集合
	 */
	private List<Integer> getAllHospital(List<Integer> list){
		List<Hospital> hlist = hservice.SelectAllHostpital(list);
		List<Integer> mlist = new ArrayList<Integer>();
		if(hlist.size()>0){
			for(Hospital h : hlist){
				mlist.add(h.getmId());
			}
		}
		return  mlist;
	}
	/**
	 * 
	 * @param list
	 * @return 所有医院下的所有医生Id
	 */
	private List<Integer> getDocIdList(List<Integer> list){
		List<DocDetail> dlist = dservice.findAllDoctor(list);
		List<Integer> mlist = new ArrayList<Integer>();
		if(dlist!=null&&dlist.size()>0){
			for(DocDetail d: dlist){
				mlist.add(d.getmDoctor().getmId());
			}
		}
		return mlist;
	}
	
}
