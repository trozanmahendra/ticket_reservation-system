package com.mgWork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgWork.entitys.Location;
import com.mgWork.service.LocationService;
@RestController
public class LocationController {
	@Autowired
	private LocationService locationService;

	@PostMapping("/admin/addlocation")
	public Location addLocation(@RequestBody Location location) {
		return locationService.addLocation(location);
		
	}
}
