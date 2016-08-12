package com.yxt.jhonelee.service;

import java.util.List;

import com.yxt.jhonelee.model.Admin;

public interface AdminService {
	public List<Admin> SelectAllAdmin(String adminName);
}
