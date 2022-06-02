package com.mgWork.service;

import com.mgWork.beans.BookedTicket;
import com.mgWork.entitys.Ticket;

public interface TicketService {

	Ticket saveTicket(Ticket ticket);
	
	BookedTicket showBookedTicket(Long id);
}
