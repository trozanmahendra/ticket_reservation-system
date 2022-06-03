package com.mgWork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.entitys.Passenger;
import com.mgWork.service.PassengerService;

@RestController
public class PassengerController {

	@Autowired
	private PassengerService passengerService;
	@PostMapping("/cust/addpassenger")
	public ResponseEntity<Passenger> savePassenger(@RequestBody Passenger passenger) {
		return new ResponseEntity<Passenger>(passengerService.savePassenger(passenger),HttpStatus.CREATED);
		
	}
}
