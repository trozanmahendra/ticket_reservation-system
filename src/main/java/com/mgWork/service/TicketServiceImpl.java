package com.mgWork.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mgWork.beans.BookedTicket;
import com.mgWork.beans.TicketMapper;
import com.mgWork.entitys.Bus;
import com.mgWork.entitys.Customer;
import com.mgWork.entitys.Passenger;
import com.mgWork.entitys.Ticket;
import com.mgWork.repository.BusRepository;
import com.mgWork.repository.CustomerRepository;
import com.mgWork.repository.PassengerRepository;
import com.mgWork.repository.TicketMapperRepository;
import com.mgWork.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
//	@Bean
//	public BookedTicket bookedTicketBean() {
//	return new BookedTicket();
//	}
	
	private TicketRepository ticketRepo;
	private BookedTicket bookedTicket;
	private BusRepository busRepository;
	private TicketMapperRepository ticketMapperRepository;
	private CustomerRepository customerRepository;
	private PassengerRepository passengerRepository;

	@Autowired
	public TicketServiceImpl(TicketRepository ticketRepo, BookedTicket bookedTicket, BusRepository busRepository,
			TicketMapperRepository ticketMapperRepository, CustomerRepository customerRepository,
			PassengerRepository passengerRepository) {
		this.ticketRepo = ticketRepo;
		this.bookedTicket = bookedTicket;
		this.busRepository = busRepository;
		this.ticketMapperRepository = ticketMapperRepository;
		this.customerRepository = customerRepository;
		this.passengerRepository = passengerRepository;
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	

	@Override
	public BookedTicket showBookedTicket(Long id) {
		TicketMapper mapper = new TicketMapper();
		
		bookedTicket.setTicket(ticketRepo.findById(id).get());
		Ticket ticket = bookedTicket.getTicket();
		
		Long bid = ticket.getBus_id();
		bookedTicket.setBus(busRepository.findById(bid).get());
		Bus bus=bookedTicket.getBus();
		
		Long cid = ticket.getCustomer_id();
		bookedTicket.setCustomer(customerRepository.findById(cid).get());
		Customer cust = bookedTicket.getCustomer();
		
		Long pid = ticket.getPassenger_id();
		bookedTicket.setPassenger(passengerRepository.findById(pid).get());
		Passenger passenger = bookedTicket.getPassenger();
		
		System.out.println("\n\n"+bus+"\n"
								+ticket
					+"\n"+passenger+"\n"+cust);
		
		BeanUtils.copyProperties(bus, mapper);
		BeanUtils.copyProperties(ticket, mapper);
		BeanUtils.copyProperties(passenger, mapper);
		BeanUtils.copyProperties(cust, mapper);
		ticketMapperRepository.save(mapper);
	
		return bookedTicket;
		
	}

}
