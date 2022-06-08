package com.mgWork.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgWork.entitys.Bus;
import com.mgWork.entitys.CancelledTicket;
import com.mgWork.entitys.Ticket;
import com.mgWork.repository.BusRepository;
import com.mgWork.repository.CancelledTicketRepository;
import com.mgWork.repository.TicketRepository;

@Service
@Transactional
public class CancelledTicketServiceImpl implements CancelledTicketService {
	@Autowired
	private CancelledTicketRepository cancelledTicketRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private BusRepository busRepository;
	
	CancelledTicket cancelledTicket = new CancelledTicket();

	@Override
	public CancelledTicket saveCancelledTicket(String tktId) {
		
		Ticket ticket = null;
		ticket = ticketRepository.findByTktId(tktId).get();
		
		Bus bus = busRepository.findById(ticket.getBus_id()).get();
//		BeanUtils.copyProperties(ticket, cancelledTicket);
		cancelledTicket.setId(0);
		cancelledTicket.setBus_id(ticket.getBus_id());
		cancelledTicket.setCustomerId(ticket.getCustomerId());
		cancelledTicket.setPassenger_id(ticket.getPassenger_id());
		cancelledTicket.setPickUp(ticket.getPickUp());
		cancelledTicket.setDropp(ticket.getDropp());
		cancelledTicket.setTktId(ticket.getTktId());
		ticketRepository.deleteByTktId(tktId);
		bus.setSeatsAvailable(bus.getSeatsAvailable()+1);
		return cancelledTicketRepository.save(cancelledTicket);
		
	}
}
