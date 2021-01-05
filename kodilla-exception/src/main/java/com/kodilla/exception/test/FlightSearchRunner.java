package com.kodilla.exception.test;

public class FlightSearchRunner {

    public static void main(String[] args) {
        Flight flightToSearch = new Flight("Moscow", "Barcelona");
        FlightSearch newSearching= new FlightSearch();

        try {
            newSearching.findFlight(flightToSearch);
        } catch (RouteNotFoundException e) {
            System.out.println("It's impossible to fly to " + flightToSearch.getArrivalAirport() + " from " + flightToSearch.getDepartureAirport() + ". Please, change destination.");
        } finally {
            System.out.println("Thank you for using our flights browser.");
        }
    }
}
