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
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.entitys.AuthModel;
import com.mgWork.entitys.Customer;
import com.mgWork.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/cust/register")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);

	}

	@PostMapping("/cust/login")
	public ResponseEntity<String> loginCustomer(@RequestBody AuthModel authModel) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authModel.getName(), authModel.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<String>("Welcome " + authModel.getName() + " \n login successful...........",
				HttpStatus.OK);
	}

}
