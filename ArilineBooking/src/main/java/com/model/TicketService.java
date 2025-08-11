package com.model;

public class TicketService {
	private FlightService flightService;

    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    public String confirmBooking(String flightId, String userId) {
        if (flightService.hasSeats(flightId)) {
            flightService.reserveSeat(flightId);
            return "Booking confirmed for " + userId + " on " + flightId;
        } else {
            return "Flight " + flightId + " is full";
        }
    }
}
