package com.mgWork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.entitys.Admin;
import com.mgWork.service.AdminService;

@RestController
public class AdminController {

	private AdminService adminService;
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	@PostMapping("/admin")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin),HttpStatus.CREATED);
		
	}
	
}
