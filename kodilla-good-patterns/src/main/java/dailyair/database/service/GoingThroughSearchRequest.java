package dailyair.database.service;

public class GoingThroughSearchRequest implements SearchRequest {
    private final String requestedDepartureAirport;
    private final String requestedArrivalAirport;
    private final String requestedGoingThroughAirport;
    private final boolean goingThrough;

    public GoingThroughSearchRequest(String requestedDepartureAirport, String requestedArrivalAirport, boolean goingThrough, String requestedGoingThroughAirport) {
        this.requestedDepartureAirport = requestedDepartureAirport;
        this.requestedArrivalAirport = requestedArrivalAirport;
        this.goingThrough = goingThrough;
        this.requestedGoingThroughAirport = requestedGoingThroughAirport;
    }

    @Override
    public String getRequestedDepartureAirport() {
        return requestedDepartureAirport;
    }

    @Override
    public String getRequestedArrivalAirport() {
        return requestedArrivalAirport;
    }

    @Override
    public String getRequestedGoingThroughAirport() {
        return requestedGoingThroughAirport;
    }

    @Override
    public boolean isGoingThrough() {
        return goingThrough;
    }
}