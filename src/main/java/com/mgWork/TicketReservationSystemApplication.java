package com.mgWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketReservationSystemApplication {
	@Autowired

	public static void main(String[] args) {

		SpringApplication.run(TicketReservationSystemApplication.class, args);

	}

}
