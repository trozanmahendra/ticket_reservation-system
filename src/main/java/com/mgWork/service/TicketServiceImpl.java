package com.mgWork.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgWork.beans.BookedTicket;
import com.mgWork.beans.TicketMapper;
import com.mgWork.entitys.Bus;
import com.mgWork.entitys.Customer;
import com.mgWork.entitys.Location;
import com.mgWork.entitys.Passenger;
import com.mgWork.entitys.SubLocation;
import com.mgWork.entitys.Ticket;
import com.mgWork.repository.BusRepository;
import com.mgWork.repository.CustomerRepository;
import com.mgWork.repository.LocationRepository;
import com.mgWork.repository.PassengerRepository;
import com.mgWork.repository.SubLocationRepository;
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
	LocationRepository locationRepository;
	@Autowired
	SubLocationRepository subLocationRepository;

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

//		if (busRepository.findById(ticket.getBus_id()) == null)
//			throw new RuntimeException("No bus Avaialbe with this bus_id : " + ticket.getBus_id());
//		
		Bus bus = busRepository.findById(ticket.getBus_id()).get();

		String origin = bus.getOrigin();
		String pickUp = ticket.getPickUp();
		String Destination = bus.getDestination();
		String drop = ticket.getDropp();
		System.out.println(origin + "--------------" + pickUp + "---------" + Destination + "--------" + drop);

		Location loc1 = locationRepository.findByLocation(origin);

		SubLocation loc2 = subLocationRepository.findBySubLoc(pickUp);
		Location loc3 = locationRepository.findByLocation(Destination);
		SubLocation loc4 = subLocationRepository.findBySubLoc(drop);

		Passenger passenger = passengerRepository.findByCustomerIdAndId(customer.getId(), ticket.getPassenger_id());
		if (passenger != null) {
			if (loc1 == loc2.getLoc() && loc3 == loc4.getLoc()) {
				int seatsAvail = bus.getSeatsAvailable();
				if (seatsAvail > 0) {
					bus.setSeatsAvailable(seatsAvail - 1);
					Bus buss = busRepository.findById(bus.getBus_id()).get();
					buss.setSeatsAvailable(seatsAvail-1);
					busRepository.save(buss);
					return ticketRepo.save(ticket);
				}else
					throw new RuntimeException(" No seats available");
			} else
				throw new RuntimeException(" pickUp or drop point errors");
		} else {
			throw new RuntimeException("Passenger details are not valid ");
		}
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

//		System.out.println("\n\n" + bus + "\n" + ticket + "\n" + passenger + "\n" + cust);
		ticketMapperRepository.deleteAll();
		BeanUtils.copyProperties(bus, mapper);
		BeanUtils.copyProperties(ticket, mapper);
		BeanUtils.copyProperties(passenger, mapper);
		BeanUtils.copyProperties(cust, mapper);
		ticketMapperRepository.save(mapper);

		Customer customer = customerService.getLoggedInCustomer();
		if (customer.getId() == cust.getId())
			return bookedTicket;
		else
			throw new RuntimeException("Invalid Ticket id " + ticket.getTktId());

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
