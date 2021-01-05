package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public void findFlight (Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Barcelona", true);

        String destination = flight.getArrivalAirport();

        if (flightMap.containsKey(destination)) {
            System.out.println("You got it! Flight to " + destination + " is possible. Check the price!");
            } else {
            throw new RouteNotFoundException();
        }
    }
}
