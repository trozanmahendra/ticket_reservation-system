package com.mgWork.service;

import com.mgWork.entitys.Admin;

public interface AdminService {

	Admin saveAdmin(Admin admin);

	Admin findAdminByNameAndpassword(String name, String password);

	public Admin getLoggedInAdmin();
}
