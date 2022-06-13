package com.mgWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Customer;
import com.mgWork.repository.AuthorityRepository;
import com.mgWork.repository.CustomerRepository;

//@Component
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AuthorityRepository authorityRepository;
	@Override
	public Customer saveCustomer(Customer customer) {
		customer.setPassword(encoder.encode(customer.getPassword()));
		customer.setAuthority(authorityRepository.findById((long) 2).get());
		return customerRepo.save(customer);
	}

	@Override
	public Customer getLoggedInCustomer() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();

		return customerRepo.findByName(name)
				.orElseThrow(() -> new RuntimeException("User not found for the name" + name));
	}

}
