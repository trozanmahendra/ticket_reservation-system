package com.mgWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Admin;
import com.mgWork.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Admin saveAdmin(Admin admin) {
		if (admin.getAdminCode().equalsIgnoreCase("dxc-bus-admin")) {
			admin.setPassword(encoder.encode(admin.getPassword()));
			return adminRepository.save(admin);
		}
		else
			throw new RuntimeException("Invalid Admin code : " + admin.getAdminCode());
	}
	@Override
	public Admin findAdminByNameAndpassword(String name, String password) {
		
		return adminRepository.findByNameAndPassword(name,password);
	}
	@Override
	public Admin getLoggedInAdmin() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		return adminRepository.findByName(name).orElseThrow(() -> new RuntimeException ("Admin not found for the name : "+name));
	}
}
