package com.mgWork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Bus;
import com.mgWork.repository.BusRepository;
@Service
public class BusServiceImpl implements BusService {
	BusRepository busRepo;

	@Autowired
	public BusServiceImpl(BusRepository busRepo) {
		this.busRepo = busRepo;
	}

	@Override
	public Bus saveBus(Bus bus) {
		return busRepo.save(bus);
	}
	
	@Override
	public List<Bus> busList(Bus bus,Pageable pageable) {
		
		return busRepo.findAll();
	}

	@Override
	public List<Bus> searchBusesByOriginAndDestination(String origin, String destination, Pageable pageable) {
		
		String org = origin,des = destination;
		System.out.println(org + "++++++++++++++++++++++++++" + des+org);
		return busRepo.findByOriginAndDestination(origin, destination, pageable);
	}
}
