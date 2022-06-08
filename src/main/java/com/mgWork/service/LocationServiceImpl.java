package com.mgWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Location;
import com.mgWork.repository.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationRepository locationRepository;
	
	public Location addLocation(Location location) {
		
		return locationRepository.save(location);
	}
}
