package com.mgWork.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Customer;
import com.mgWork.repository.CustomerRepository;
//@Component
@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepo;
	
	private PasswordEncoder encoder;
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepo, PasswordEncoder encoder) {
		super();
		this.customerRepo = customerRepo;
		this.encoder = encoder;
	}
	@Override
	public Customer saveCustomer(Customer customer) {
		customer.setPassword(encoder.encode(customer.getPassword()));
		return customerRepo.save(customer);
	}
	
	@Override
	public Customer getLoggedInCustomer() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		
		return customerRepo.findByName(name).orElseThrow(() -> new UsernameNotFoundException("User not found for the name"+name));
	}

}
































