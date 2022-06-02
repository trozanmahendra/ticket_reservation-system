package com.mgWork.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mgWork.entitys.Bus;

public interface BusService {

	Bus saveBus(Bus bus);
	
	List<Bus> busList(Bus bus,Pageable pageable);
}
