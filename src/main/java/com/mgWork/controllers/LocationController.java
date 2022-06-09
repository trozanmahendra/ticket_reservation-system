package com.mgWork.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/admin/listlocations")
	public ResponseEntity<List<Location>> listLocations(){
		return new ResponseEntity<List<Location>>(locationService.listLocations(),HttpStatus.OK);
	}
	@PutMapping("/admin/updatelocation")
	public ResponseEntity<Location> updateLocation(@RequestParam Long id,@RequestBody Location location){
		return new ResponseEntity<Location>(locationService.updateLocation(id,location),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/admin/deletelocation")
	public ResponseEntity<String> locationService(@RequestParam Long id){
		locationService.locationService(id);
		return new ResponseEntity<String>("Location deleted Successfully of id : "+id,HttpStatus.OK);
	}
}
