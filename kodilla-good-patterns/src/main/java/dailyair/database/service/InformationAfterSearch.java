package dailyair.database.service;

import java.util.Set;
import java.util.stream.Collectors;

public class InformationAfterSearch {

    void departureAirportInformation(SearchRequest searchRequest, Set<Flight> flightSet) {
        if (flightSet.isEmpty()) {
            System.out.println("There are no flights from the selected airport.");
        } else {
            System.out.println("\nList of flights from: " + searchRequest.getRequestedDepartureAirport());
            for (Flight flight : flightSet) {
                System.out.println(flight);
            }
        }
    }

    void arrivalAirportInformation(SearchRequest searchRequest, Set<Flight> flightSet) {
        if (flightSet.isEmpty()) {
            System.out.println("There are no flights to the selected airport.");
        } else {
            System.out.println("\nList of flights to: " + searchRequest.getRequestedArrivalAirport());
            for (Flight flight : flightSet) {
                System.out.println(flight);
            }
        }
    }

    void goingThroughInformation(SearchRequest searchRequest, Set<Flight> flightSet) {
        if (flightSet.isEmpty()) {
            System.out.println("There are no flights covering selected trips.");
        } else if (goingThroughArrivalAirportCheck(searchRequest, flightSet)) {
            System.out.println("There are no flights from: " + searchRequest.getRequestedDepartureAirport() + " to: " + searchRequest.getRequestedGoingThroughAirport());
            System.out.println("List of flights from: " + searchRequest.getRequestedGoingThroughAirport() + " to: " + searchRequest.getRequestedArrivalAirport() + " below:");
            for (Flight flight : flightSet) {
                System.out.println(flight);
            }
        } else if (goingThroughDepartureAirportCheck(searchRequest, flightSet)) {
            System.out.println("There are no flights from: " + searchRequest.getRequestedGoingThroughAirport() + " to: " + searchRequest.getRequestedArrivalAirport());
            System.out.println("List of flights from: " + searchRequest.getRequestedDepartureAirport() + " to: " + searchRequest.getRequestedGoingThroughAirport() + " below:");
            for (Flight flight : flightSet) {
                System.out.println(flight);
            }
        } else {
            System.out.println("\nList of flights from: " + searchRequest.getRequestedDepartureAirport() + " to: " + searchRequest.getRequestedArrivalAirport() + " via: " + searchRequest.getRequestedGoingThroughAirport());
            for (Flight flight : flightSet) { System.out.println(flight);
            }
       }
    }

    private boolean goingThroughDepartureAirportCheck(SearchRequest searchRequest, Set<Flight> flightSet) {
        Set<Flight> setToCheck = flightSet.stream()
                .filter(flight -> flight.getDepartureAirport().equals(searchRequest.getRequestedGoingThroughAirport()))
                .collect(Collectors.toSet());
        return setToCheck.isEmpty();
    }

    private boolean goingThroughArrivalAirportCheck(SearchRequest searchRequest, Set<Flight> flightSet) {
        Set<Flight> setToCheck = flightSet.stream()
                .filter(flight -> flight.getArrivalAirport().equals(searchRequest.getRequestedGoingThroughAirport()))
                .collect(Collectors.toSet());
        return setToCheck.isEmpty();
    }
}
