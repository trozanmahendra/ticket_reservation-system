package com.mgWork.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.beans.BookedTicket;
import com.mgWork.beans.TicketMapper;
import com.mgWork.entitys.Ticket;
import com.mgWork.repository.TicketMapperRepository;
import com.mgWork.repository.TicketRepository;
import com.mgWork.service.TicketMapperService;
import com.mgWork.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService service;
	@Autowired
	private TicketMapperService mapperService;
	
	private TicketMapperRepository ticketrepo;
	
	
	@PostMapping("/cust/bookticket")
	public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
		return new ResponseEntity<Ticket>(service.saveTicket(ticket),HttpStatus.CREATED);
	}

	@GetMapping("/cust/showbookedticket/{id}")
	public ResponseEntity<List<TicketMapper>> showBookedTicket(@PathVariable Long id){
		
	
		service.showBookedTicket(id);

		return new ResponseEntity<List<TicketMapper>>(mapperService.showMappers(), HttpStatus.OK);
	}
	
}
