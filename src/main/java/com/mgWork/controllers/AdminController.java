package com.mgWork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.dto.AuthModel;
import com.mgWork.entitys.Customer;
import com.mgWork.service.AdminService;
import com.mgWork.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AdminService adminService;

	@PostMapping("/register")
	public ResponseEntity<Customer> registerAdmin(@RequestBody Customer admin) {
		return new ResponseEntity<Customer>(adminService.saveAdmin(admin), HttpStatus.CREATED);

	}
	@PostMapping("/login")
	public ResponseEntity<String> loginCustomer(@RequestBody AuthModel authModel) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authModel.getName(), authModel.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
//		if (customerService.getLoggedInCustomer().getAdminCode().equalsIgnoreCase("dxc-bus-admin")) {
		
//		boolean flag= customerService.getLoggedInCustomer().getAdminCode().equalsIgnoreCase("dxc-bus-admin");
		if (customerService.getLoggedInCustomer().getAdminCode() != null ) {	
			return new ResponseEntity<String>(
					"Welcome admin : " + authModel.getName() + " \n login successful...........", HttpStatus.OK);
		} else {
			throw new RuntimeException("please register as admin or login as customer");
		}
	}

}
