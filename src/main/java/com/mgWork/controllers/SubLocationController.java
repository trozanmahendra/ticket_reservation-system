package com.mgWork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.entitys.SubLocation;
import com.mgWork.service.SubLocationService;

@RestController
@RequestMapping("/admin")
public class SubLocationController {
	@Autowired
	private SubLocationService subLocationService;

	@PostMapping("/addsublocation")
	public SubLocation saveSubLocation(@RequestBody SubLocation subLocation) {
		return subLocationService.addSublocation(subLocation);
		
	}
}
