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

                System.out.println("\nList of flights from: " + searchRequest.getRequestedDepartureAirport());
                for (Flight flight : processedFlights) {
                    System.out.println(flight);
                }
            } else {
                processedFlights = flightDatabase.getFlightDatabase().stream()
                        .filter(flight -> flight.getArrivalAirport().equals(searchRequest.getRequestedArrivalAirport()))
                        .collect(Collectors.toSet());

                System.out.println("\nList of flights to: " + searchRequest.getRequestedArrivalAirport());
                for (Flight flight : processedFlights) {
                    System.out.println(flight);
                }

            }
        } else {
            processedFlights = flightDatabase.getFlightDatabase().stream()
                    .filter(flight -> (flight.getDepartureAirport().equals(searchRequest.getRequestedDepartureAirport()) && flight.getArrivalAirport().equals(searchRequest.getRequestedGoingThroughAirport()) ||
                            flight.getDepartureAirport().equals(searchRequest.getRequestedGoingThroughAirport()) && flight.getArrivalAirport().equals(searchRequest.getRequestedArrivalAirport())))
                    .collect(Collectors.toSet());

            System.out.println("\nList of flights from: " + searchRequest.getRequestedDepartureAirport() + " to: " + searchRequest.getRequestedArrivalAirport() + " via: " + searchRequest.getRequestedGoingThroughAirport());
            for (Flight flight : processedFlights) {
                System.out.println(flight);
            }
        }
        return processedFlights;
    }
}



