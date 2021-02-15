package dailyair.database.service;

public interface SearchRequest {
    String getRequestedArrivalAirport();
    String getRequestedGoingThroughAirport();
    String getRequestedDepartureAirport();
    boolean isGoingThrough();
}
