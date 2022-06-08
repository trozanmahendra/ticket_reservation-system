package com.mgWork.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.entitys.CancelledTicket;
import com.mgWork.service.CancelledTicketService;

@RestController
@Transactional
public class CancelledTicketController {

	@Autowired
	private CancelledTicketService cancelledTicketService;

	@GetMapping("/cust/cancelticket")
	public ResponseEntity<CancelledTicket> cancelTicket(@RequestParam String tktId) {

		return new ResponseEntity<CancelledTicket>(cancelledTicketService.saveCancelledTicket(tktId),
				HttpStatus.ACCEPTED);
	}
}
