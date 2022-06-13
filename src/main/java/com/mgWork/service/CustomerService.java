package com.mgWork.service;

import com.mgWork.entitys.Admin;
import com.mgWork.entitys.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	Customer getLoggedInCustomer();

	
}
