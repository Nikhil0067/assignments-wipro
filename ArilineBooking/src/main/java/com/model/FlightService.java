package com.model;

import java.util.HashMap;
import java.util.Map;

public class FlightService {
	private Map<String, Integer> flightSeats;

    public FlightService() {
        flightSeats = new HashMap<>();
        flightSeats.put("FL123", 2);
        flightSeats.put("FL456", 0); 
    }

    public boolean hasSeats(String flightId) {
        Integer seats = flightSeats.get(flightId);
        return seats != null && seats > 0;
    }

    public void reserveSeat(String flightId) {
        if (hasSeats(flightId)) {
            flightSeats.put(flightId, flightSeats.get(flightId) - 1);
        }
    }
}