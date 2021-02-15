package dailyair.database.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FlightDatabaseRetriever {

    public FlightDatabase retrieve() {

        Flight flight1 = new FlightDailyAir("Wroclaw", "Krakow", 1207);
        Flight flight2 = new FlightDailyAir("Wroclaw", "Gdansk", 1176);
        Flight flight3 = new FlightDailyAir("Wroclaw", "Warszawa", 1203);
        Flight flight4 = new FlightDailyAir("Gdansk", "Warszawa", 2276);
        Flight flight5 = new FlightDailyAir("Gdansk", "Krakow", 1099);
        Flight flight6 = new FlightDailyAir("Warszawa", "Wroclaw", 2111);
        Flight flight7 = new FlightDailyAir("Krakow", "Warszawa", 1202);
        Flight flight8 = new FlightDailyAir("Krakow", "Wroclaw", 3721);

        Set<Flight> databaseToRetrieve = new HashSet<>(Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8));

        return new FlightDatabase(databaseToRetrieve);
    }
}
