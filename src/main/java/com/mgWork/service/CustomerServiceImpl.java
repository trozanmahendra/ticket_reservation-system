package com.mgWork.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Customer;
import com.mgWork.repository.CustomerRepository;
//@Component
@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepo;
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

}
