package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.TicketService;

public class AirlineMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        TicketService ticketService = (TicketService) context.getBean("ticketService");

        System.out.println(ticketService.confirmBooking("FL123", "USER456"));
        System.out.println(ticketService.confirmBooking("FL456", "USER789"));
	}
}
