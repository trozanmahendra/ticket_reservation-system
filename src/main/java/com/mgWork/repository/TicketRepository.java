package com.mgWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgWork.entitys.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
