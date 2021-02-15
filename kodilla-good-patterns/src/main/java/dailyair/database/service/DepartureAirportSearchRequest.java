package dailyair.database.service;

public class DepartureAirportSearchRequest implements SearchRequest {
    private final String requestedDepartureAirport;

    public DepartureAirportSearchRequest(String requestedDepartureAirport) {
        this.requestedDepartureAirport = requestedDepartureAirport;
    }

    @Override
    public String getRequestedDepartureAirport() {
        return requestedDepartureAirport;
    }

    @Override
    public String getRequestedArrivalAirport() {
        return null;
    }

    @Override
    public String getRequestedGoingThroughAirport() {
        return null;
    }

    @Override
    public boolean isGoingThrough() {
        return false;
    }
}
