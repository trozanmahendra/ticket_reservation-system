package com.mgWork.beans;

import java.io.Serializable;

import com.mgWork.entitys.Bus;
import com.mgWork.entitys.Customer;
import com.mgWork.entitys.Passenger;
import com.mgWork.entitys.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
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

	public BookedTicket() {

	}

}
