package com.mgWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Admin;
import com.mgWork.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	private AdminRepository adminRepository;
	
	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}


	@Override
	public Admin saveAdmin(Admin admin) {
		
		return adminRepository.save(admin);
	}
}
