package dailyair.database.service;


public interface Flight {
    String getArrivalAirport();
    String getDepartureAirport();
    int getFlightNumber();
    String toString();
}
