package dailyair.database.service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchService {

    private final FlightDatabase flightDatabase;
    private final InformationAfterSearch informationAfterSearch;

    public SearchService(FlightDatabase flightDatabase, InformationAfterSearch informationAfterSearch) {
        this.flightDatabase = flightDatabase;
        this.informationAfterSearch = informationAfterSearch;
    }

    public Set<Flight> process(SearchRequest searchRequest) {
        Set<Flight> processedFlights;

        if (!searchRequest.isGoingThrough()) {
            if (searchRequest.getRequestedArrivalAirport() == null) {
                processedFlights = flightDatabase.getFlightDatabase().stream()
                        .filter(flight -> Objects.equals(flight.getDepartureAirport(), searchRequest.getRequestedDepartureAirport()))
                        .collect(Collectors.toSet());

                informationAfterSearch.departureAirportInformation(searchRequest, processedFlights);
            } else {
                processedFlights = flightDatabase.getFlightDatabase().stream()
                        .filter(flight -> flight.getArrivalAirport().equals(searchRequest.getRequestedArrivalAirport()))
                        .collect(Collectors.toSet());

                informationAfterSearch.arrivalAirportInformation(searchRequest, processedFlights);
            }
        } else {
            processedFlights = flightDatabase.getFlightDatabase().stream()
                    .filter(flight -> (flight.getDepartureAirport().equals(searchRequest.getRequestedDepartureAirport()) && flight.getArrivalAirport().equals(searchRequest.getRequestedGoingThroughAirport()) ||
                            flight.getDepartureAirport().equals(searchRequest.getRequestedGoingThroughAirport()) && flight.getArrivalAirport().equals(searchRequest.getRequestedArrivalAirport())))
                    .collect(Collectors.toSet());

            informationAfterSearch.goingThroughInformation(searchRequest, processedFlights);
        }
        return processedFlights;
    }
}



