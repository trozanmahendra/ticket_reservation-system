package com.mgWork.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mgWork.entitys.Bus;
import com.mgWork.entitys.Passenger;
import com.mgWork.entitys.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketMapper {
	
	@Transient
	@JsonIgnore
	private Ticket ticket;
	@Transient
	@JsonIgnore
	private Bus bus;
	@Transient
	@JsonIgnore
	private Passenger passenger;

	@Id
	private String tktId ;

	private String psngr_name ;
	private int psngr_age ;
	private String mobileNumber;
	
	private String bus_name ;
	private String regId ;
	private String bus_type ;
	private int seats ;
	private int seatsAvailable ;
	private String origin ;
	private String pickUp ;
	private String destination ;
	private String dropp ;
	private float tkt_fare ;
	
	private String status;

	private Date start_date ;

	private Date end_date ;

	

	
	
}





















