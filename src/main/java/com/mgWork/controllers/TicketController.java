package com.mgWork.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.dto.TicketMapper;
import com.mgWork.entitys.Ticket;
import com.mgWork.service.TicketMapperService;
import com.mgWork.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService service;
	@Autowired
	private TicketMapperService mapperService;
//	@Autowired
	

	@PostMapping("/cust/bookticket")
	public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
			return new ResponseEntity<Ticket>(service.saveTicket(ticket), HttpStatus.CREATED);
	}
	@GetMapping("/cust/cancelticket")
	public ResponseEntity<Ticket> cancelTicket(@RequestParam String tktId,Ticket ticket) throws ParseException {
		return new ResponseEntity<Ticket>(service.saveCancelledTicket(tktId,ticket), HttpStatus.CREATED);
}
	

	@GetMapping("/cust/showbookedticket/{id}")
	public ResponseEntity<List<TicketMapper>> showBookedTicket(@PathVariable String id) {

		service.showBookedTicket(id);

		return new ResponseEntity<List<TicketMapper>>(mapperService.showMappers(), HttpStatus.OK);
	}

	@GetMapping("/cust/showtickets")
	public ResponseEntity<List<Ticket>> showTickets() {
		return new ResponseEntity<List<Ticket>>(service.showTickets(), HttpStatus.OK);

	}

	@GetMapping("/cust/getticket/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable String id) {
		return new ResponseEntity<Ticket>(service.getTicket(id), HttpStatus.OK);
	}

}
