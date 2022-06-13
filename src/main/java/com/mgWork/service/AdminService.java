package com.mgWork.service;

import com.mgWork.entitys.Customer;

public interface AdminService {

//	Admin saveAdmin(Admin admin);

//	Admin findAdminByNameAndpassword(String name, String password);

	public Customer getLoggedInAdmin();

	Customer saveAdmin(Customer admin);
}
