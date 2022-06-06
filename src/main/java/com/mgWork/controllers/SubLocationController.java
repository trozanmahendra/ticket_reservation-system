package com.mgWork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.entitys.SubLocation;
import com.mgWork.service.SubLocationService;

@RestController
public class SubLocationController {
	@Autowired
	private SubLocationService subLocationService;

	@PostMapping("/admin/addsublocation")
	public SubLocation saveSubLocation(@RequestBody SubLocation subLocation) {
		return subLocationService.addSublocation(subLocation);
		
	}
}
