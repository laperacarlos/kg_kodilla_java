package dailyair.database.service;

public class MainDailyAir {

    public static void main(String[] args) {
        FlightDatabaseRetriever flightDatabaseRetriever = new FlightDatabaseRetriever();
        FlightDatabase testDataBase = flightDatabaseRetriever.retrieve();

        DepartureAirportSearchRequest departureAirportSearchRequest = new DepartureAirportSearchRequest("Wroclaw");
        ArrivalAirportSearchRequest arrivalAirportSearchRequest = new ArrivalAirportSearchRequest("Warszawa");
        GoingThroughSearchRequest goingThroughRequest = new GoingThroughSearchRequest("Wroclaw", "Warszawa", true, "Gdansk");

        SearchService searchService = new SearchService(testDataBase);

        searchService.process(departureAirportSearchRequest);
        searchService.process(arrivalAirportSearchRequest);
        searchService.process(goingThroughRequest);
    }
}
