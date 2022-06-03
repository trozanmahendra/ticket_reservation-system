package com.mgWork.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.entitys.Bus;
import com.mgWork.service.BusService;

@RestController
public class BusController {

	private BusService busService;
	@Autowired
	public BusController(BusService busService) {
		super();
		this.busService = busService;
	}
	
	@PostMapping("/admin/addbus")
	public ResponseEntity<Bus> saveBus(@RequestBody Bus bus){
		return new ResponseEntity<Bus>(busService.saveBus(bus),HttpStatus.CREATED);
	}
	@GetMapping("/admin/buses")
	public List<Bus> busList(Bus bus,Pageable pageable){
		return busService.busList(bus, pageable);
	}
	
	
}






















