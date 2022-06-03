package com.mgWork.beans;

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
//	@Id
//	@JsonIgnore
//	private Long id;
	@Id
	private String tktId ;

	private String psngr_name ;
	private int psngr_age ;

	private String bus_name ;
	private String regId ;
	private String bus_type ;
	private int seats ;
	private String origin ;
	private String pickup_point ;
	private String destination ;
	private String drop_point ;
	private float tkt_fare ;

	private Date start_date ;

	private Date end_date ;

	

	
	
}





















