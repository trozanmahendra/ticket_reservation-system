package com.mgWork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgWork.dto.TicketMapper;
import com.mgWork.repository.TicketMapperRepository;
@Service
public class TicketMapperServiceImpl implements TicketMapperService{
//	@Autowired
//	private TicketMapperRepository ticketMapperRepo;

	@Override
	public List<TicketMapper> showMappers() {
//		return ticketMapperRepo.findAll();
		return null;
	}
}
