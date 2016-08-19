package com.yxt.jhonelee.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yxt.jhonelee.model.ITVRecord;
import com.yxt.jhonelee.service.ITVRecordService;


/**
 * 
 * @author JhoneLee
 * @category 管理员控制器
 *
 */
@Controller
public class ITVRecordController {

	@Autowired
	private ITVRecordService adminService;
/**
 * 
 * @param request
 * @param out 输出显示管理员的统计结果
 */
	@RequestMapping("/showRecord")
	public void SelectAllRecord(HttpServletRequest request, PrintWriter out) {
		String sid = request.getParameter("id");
		int id = 0;
		Gson gson = new Gson();
		if (sid != null) {
			id = Integer.parseInt(sid);
			ITVRecord itvRecord = adminService.SelectAllRecord(id);
			if (itvRecord != null) {
				String json = gson.toJson(itvRecord);
				out.write(json);
			}
		}
	}

	// 插入数据到数据库当中

	@RequestMapping("/insertReason")
	public void insertReason(HttpServletRequest request, PrintWriter out) {
		try {
			request.setCharacterEncoding("utf-8");
			String shandle = request.getParameter("handle");
			String sadminid = request.getParameter("adminid");
			String sregistid = request.getParameter("registid");
			String suserreason = request.getParameter("userreason");
			String sdocreason = request.getParameter("docreason");
			ITVRecord itvRecord = new ITVRecord();
			if (sadminid != null) {
				itvRecord.setmAdminId(Integer.parseInt(sadminid));
				if (sregistid != null) {
					itvRecord.setmRegistId(Integer.parseInt(sregistid));
					if (shandle != null) {
						itvRecord.setmHandle(Integer.parseInt(shandle));
						itvRecord.setmDocReason(sdocreason);
						itvRecord.setmUserReason(suserreason);
						if (adminService.InsertRecord(itvRecord) != null) {
							out.write("添加成功");
						} else {
							out.write("添加失败");
						}
					} else {
						out.write("添加失败");
					}
				} else {
					out.write("添加失败");
				}
			} else {
				out.write("添加失败");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
