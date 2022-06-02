package com.mgWork.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Future;

import org.springframework.beans.factory.annotation.Autowired;

import com.mgWork.entitys.Bus;
import com.mgWork.entitys.Customer;
import com.mgWork.entitys.Passenger;
import com.mgWork.entitys.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class BookedTicket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Ticket ticket;
	private Passenger passenger;
	private Bus bus;
	private Customer customer;
	
	public BookedTicket(){
		
	}

//	@Autowired
//	public BookedTicket(Ticket ticket, Passenger passenger, Bus bus, Customer customer) {
//		super();
//		this.ticket = ticket;
//		this.passenger = passenger;
//		this.bus = bus;
//		this.customer = customer;
//	}

//	private String tktId = ticket.getTkt_id();
//	private String psngrName = passenger.getPsngr_name();
//	private int psngrAge = passenger.getPsngr_age();
//	private String busName = bus.getBus_name();
//	private String busRegId = bus.getRegId();
//	private String busType = bus.getBus_type();
//	private int seats = bus.getSeats();
//	private String origin = bus.getOrigin();
//	private String pickup_point = bus.getPickup_point();
//	private String destination = bus.getDestination();
//	private String drop_point = bus.getDrop_point();
//	private float tkt_fare = bus.getTkt_fare();
//
//	private Date start_date = bus.getStart_date();
//
//	private Date end_date = bus.getEnd_date();

//	@Override
//	public String toString() {
//		return "BookedTicket [tktId=" + tktId + ", psngrName=" + psngrName + ", psngrAge=" + psngrAge + ", busName="
//				+ busName + ", busRegId=" + busRegId + ", busType=" + busType + ", seats=" + seats + ", origin="
//				+ origin + ", pickup_point=" + pickup_point + ", destination=" + destination + ", drop_point="
//				+ drop_point + ", tkt_fare=" + tkt_fare + ", start_date=" + start_date + ", end_date=" + end_date + "]";
//	}
	
	

}
