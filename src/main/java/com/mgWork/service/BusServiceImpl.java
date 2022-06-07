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
	BusRepository busRepo;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	SubLocationRepository subLocationRepository;

	@Autowired
	public BusServiceImpl(BusRepository busRepo) {
		this.busRepo = busRepo;
	}

	@Override
	public Bus saveBus(Bus bus) {
//		String origin = bus.getOrigin();
//		String pickUp = bus.getPickup_point();
//		String Destination = bus.getDestination();
//		String drop = bus.getDrop_point();
//		System.out.println(origin+"--------------"+pickUp+"---------"+Destination+"--------"+drop);
//		Location loc1 = locationRepository.findByLocation(origin);
//		SubLocation loc2 = subLocationRepository.findBySubLoc(pickUp);
//		Location loc3 = locationRepository.findByLocation(Destination);
//		SubLocation loc4 = subLocationRepository.findBySubLoc(drop);
//
//		if (loc1 == loc2.getLoc() && loc3 == loc4.getLoc())
			return busRepo.save(bus);
//		else
//			throw new RuntimeException("pickUp or drop point errors");
	}

	@Override
	public List<Bus> busList(Bus bus, Pageable pageable) {

		return busRepo.findAll();
	}

	@Override
	public List<Bus> searchBusesByOriginAndDestination(String origin, String destination, Pageable pageable) {

		String org = origin, des = destination;
		System.out.println(org + "++++++++++++++++++++++++++" + des + org);
		return busRepo.findByOriginAndDestination(origin, destination, pageable);
	}
}
