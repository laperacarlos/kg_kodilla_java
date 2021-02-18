package dailyair.database.service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchService {

    private final FlightDatabase flightDatabase;

    public SearchService(FlightDatabase flightDatabase) {
        this.flightDatabase = flightDatabase;
    }

    public Set<Flight> process(SearchRequest searchRequest) {
        Set<Flight> processedFlights;

        if (!searchRequest.isGoingThrough()) {
            if (searchRequest.getRequestedArrivalAirport() == null) {
                processedFlights = flightDatabase.getFlightDatabase().stream()
                        .filter(flight -> Objects.equals(flight.getDepartureAirport(), searchRequest.getRequestedDepartureAirport()))
                        .collect(Collectors.toSet());

                if (processedFlights.isEmpty()) {
                    System.out.println("\nThere are no flights from the selected airport.");
                } else {
                    System.out.println("\nList of flights from: " + searchRequest.getRequestedDepartureAirport());
                    for (Flight flight : processedFlights) {
                        System.out.println(flight);
                    }
                }
            } else {
                processedFlights = flightDatabase.getFlightDatabase().stream()
                        .filter(flight -> flight.getArrivalAirport().equals(searchRequest.getRequestedArrivalAirport()))
                        .collect(Collectors.toSet());

                if (processedFlights.isEmpty()) {
                    System.out.println("\nThere are no flights to the selected airport.");
                } else {
                    System.out.println("\nList of flights to: " + searchRequest.getRequestedArrivalAirport());
                    for (Flight flight :processedFlights) {
                        System.out.println(flight);
                    }
                }
            }
        } else {

            processedFlights = flightDatabase.getFlightDatabase().stream()
                    .filter(flight -> (flight.getDepartureAirport().equals(searchRequest.getRequestedDepartureAirport()) && flight.getArrivalAirport().equals(searchRequest.getRequestedGoingThroughAirport()) ||
                            flight.getDepartureAirport().equals(searchRequest.getRequestedGoingThroughAirport()) && flight.getArrivalAirport().equals(searchRequest.getRequestedArrivalAirport())))
                    .collect(Collectors.toSet());

            if (processedFlights.isEmpty()) {
                System.out.println("\nThere are no flights covering selected trips.");
            } else if (goingThroughArrivalAirportCheck(searchRequest, processedFlights)) {
                System.out.println("\nThere are no flights from: " + searchRequest.getRequestedDepartureAirport() + " to: " + searchRequest.getRequestedGoingThroughAirport());
                System.out.println("List of flights from: " + searchRequest.getRequestedGoingThroughAirport() + " to: " + searchRequest.getRequestedArrivalAirport() + " below:");
                for (Flight flight : processedFlights) {
                    System.out.println(flight);
                }
            } else if (goingThroughDepartureAirportCheck(searchRequest, processedFlights)) {
                System.out.println("\nThere are no flights from: " + searchRequest.getRequestedGoingThroughAirport() + " to: " + searchRequest.getRequestedArrivalAirport());
                System.out.println("List of flights from: " + searchRequest.getRequestedDepartureAirport() + " to: " + searchRequest.getRequestedGoingThroughAirport() + " below:");
                for (Flight flight : processedFlights) {
                    System.out.println(flight);
                }
            } else {
                System.out.println("\nList of flights from: " + searchRequest.getRequestedDepartureAirport() + " to: " + searchRequest.getRequestedArrivalAirport() + " via: " + searchRequest.getRequestedGoingThroughAirport());
                for (Flight flight : processedFlights) {
                    System.out.println(flight);
                }
            }
        }
        return processedFlights;
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



