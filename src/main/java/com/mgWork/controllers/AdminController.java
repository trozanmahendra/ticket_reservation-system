package com.mgWork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping("/admin/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/admin/login")
	public ResponseEntity<String> loginAdmin(@RequestParam String name,@RequestParam String password){
		
		Admin admin=adminService.findAdminByNameAndpassword(name,password);
		return new ResponseEntity<String>("Welcome "+admin.getName()+"\nlogin Successful......."
				,HttpStatus.OK);
		
	}
	
}
