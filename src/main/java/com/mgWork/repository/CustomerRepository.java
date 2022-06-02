package com.mgWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgWork.entitys.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
