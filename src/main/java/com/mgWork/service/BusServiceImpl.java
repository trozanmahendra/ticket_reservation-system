package com.mgWork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Bus;
import com.mgWork.repository.BusRepository;
import com.mgWork.repository.LocationRepository;
import com.mgWork.repository.SubLocationRepository;

@Service
public class BusServiceImpl implements BusService {
	@Autowired
	BusRepository busRepo;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	SubLocationRepository subLocationRepository;

	@Autowired
	AdminService adminService;

	@Override
	public Bus saveBus(Bus bus) {

		return busRepo.save(bus);

	}

	@Override
	public List<Bus> busList(Bus bus, Pageable pageable) {

		return busRepo.findAll();
	}

	@Override
	public List<Bus> searchBusesByOriginAndDestination(String origin, String destination, Pageable pageable) {

		return busRepo.findByOriginAndDestination(origin, destination, pageable);
	}
}
