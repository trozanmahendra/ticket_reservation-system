package com.mgWork.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	TicketMapper mapper = new TicketMapper();

	private TicketRepository ticketRepo;
	private BookedTicket bookedTicket;
	private BusRepository busRepository;
	private TicketMapperRepository ticketMapperRepository;
	private CustomerRepository customerRepository;
	private PassengerRepository passengerRepository;
	@Autowired
	private CustomerService customerService;

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

		Customer customer = customerService.getLoggedInCustomer();

		ticket.setCustomerId(customer.getId());

		return ticketRepo.save(ticket);
	}

	@Override
	public BookedTicket showBookedTicket(String id) {

		bookedTicket.setTicket(ticketRepo.findByTktId(id).get());
		Ticket ticket = bookedTicket.getTicket();
//System.out.println(ticket.getBus_id());
		Long bid = ticket.getBus_id();
		bookedTicket.setBus(busRepository.findById(bid).get());
		Bus bus = bookedTicket.getBus();
//System.out.println(ticket.getCustomer_id()+"====================================");
		Long cid = ticket.getCustomerId();
		bookedTicket.setCustomer(customerRepository.findById(cid).get());
		Customer cust = bookedTicket.getCustomer();
//System.out.println(ticket.getPassenger_id()+"====================================");
		Long pid = ticket.getPassenger_id();
		bookedTicket.setPassenger(passengerRepository.findById(pid).get());
		Passenger passenger = bookedTicket.getPassenger();

		System.out.println("\n\n" + bus + "\n" + ticket + "\n" + passenger + "\n" + cust);
		ticketMapperRepository.deleteAll();
		BeanUtils.copyProperties(bus, mapper);
		BeanUtils.copyProperties(ticket, mapper);
		BeanUtils.copyProperties(passenger, mapper);
		BeanUtils.copyProperties(cust, mapper);
		ticketMapperRepository.save(mapper);

		return bookedTicket;

	}

	@Override
	public List<Ticket> showTickets() {
		Customer customer = customerService.getLoggedInCustomer();
		return ticketRepo.findByCustomerId(customer.getId());
	}

	@Override
	public Ticket getTicket(String id) {

		return ticketRepo.findByTktId(id).get();
	}

}
