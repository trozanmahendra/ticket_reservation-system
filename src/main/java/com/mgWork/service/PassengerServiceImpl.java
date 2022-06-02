package com.mgWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Passenger;
import com.mgWork.repository.PassengerRepository;
@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	private PassengerRepository passengerRepo;

	@Override
	public Passenger savePassenger(Passenger passenger) {
		return passengerRepo.save(passenger);
	}
}
