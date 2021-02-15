package dailyair.database.service;

public class ArrivalAirportSearchRequest implements SearchRequest {
    private final String requestedArrivalAirport;

    public ArrivalAirportSearchRequest(String requestedArrivalAirport) {
        this.requestedArrivalAirport = requestedArrivalAirport;
    }

    @Override
    public String getRequestedDepartureAirport() {
        return null;
    }

    @Override
    public String getRequestedArrivalAirport() {
        return requestedArrivalAirport;
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
