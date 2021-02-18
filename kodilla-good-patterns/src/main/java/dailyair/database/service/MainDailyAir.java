package dailyair.database.service;

public class MainDailyAir {

    public static void main(String[] args) {
        FlightDatabaseRetriever flightDatabaseRetriever = new FlightDatabaseRetriever();
        FlightDatabase testDataBase = flightDatabaseRetriever.retriever();

        DepartureAirportSearchRequest departureAirportSearchRequest = new DepartureAirportSearchRequest("Wroclaw");
        ArrivalAirportSearchRequest arrivalAirportSearchRequest = new ArrivalAirportSearchRequest("Warszawa");
        GoingThroughSearchRequest goingThroughRequest = new GoingThroughSearchRequest("Gdansk", "Warszawa", true, "Wroclaw");

        SearchService searchService = new SearchService(testDataBase);

        searchService.process(departureAirportSearchRequest);
        searchService.process(arrivalAirportSearchRequest);
        searchService.process(goingThroughRequest);
    }
}
