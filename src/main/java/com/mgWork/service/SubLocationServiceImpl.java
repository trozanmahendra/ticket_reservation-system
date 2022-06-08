package com.mgWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.SubLocation;
import com.mgWork.repository.SubLocationRepository;

@Service
public class SubLocationServiceImpl implements SubLocationService {
	@Autowired
	private SubLocationRepository subLocationRepository;

	@Override
	public SubLocation addSublocation(SubLocation subLocation) {
		return subLocationRepository.save(subLocation);
	}

}
