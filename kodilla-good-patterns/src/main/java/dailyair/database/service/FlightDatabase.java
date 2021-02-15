package dailyair.database.service;

import java.util.Set;

public class FlightDatabase {

    private final Set<Flight> flightDatabase;

    public FlightDatabase(Set<Flight> flightDatabase) {
        this.flightDatabase = flightDatabase;
    }

    public void addFlight(Flight flight) {
        flightDatabase.add(flight);
    }

    public void removeFlight(Flight flight) {
        flightDatabase.remove(flight);
    }

    public Set<Flight> getFlightDatabase() {
        return flightDatabase;
    }
}
