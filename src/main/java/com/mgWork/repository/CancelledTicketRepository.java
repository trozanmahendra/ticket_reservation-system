package com.mgWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgWork.entitys.CancelledTicket;

public interface CancelledTicketRepository extends JpaRepository<CancelledTicket, Long>{

	
}
