package com.mgWork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.entitys.Customer;
import com.mgWork.service.CustomerService;

@RestController
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/cust/register")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer  customer){
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
		
	}
	
//	public ResponseEntity<Customer> loginCustomer(Customer customer){
//		return new ResponseEntity<Customer>(customerService.findByName())
//	}
	
}
























