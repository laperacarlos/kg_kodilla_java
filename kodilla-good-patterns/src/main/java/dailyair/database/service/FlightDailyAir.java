package dailyair.database.service;

public class FlightDailyAir implements Flight {
    private final String departureAirport;
    private final String arrivalAirport;
    private final int flightNumber;


    public FlightDailyAir(final String departureAirport, final String arrivalAirport,  final int flightNumber) {
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.flightNumber = flightNumber;
    }

    @Override
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public int getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        return "Flight no. " + flightNumber + " from: " + departureAirport + " to: " + arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightDailyAir that = (FlightDailyAir) o;

        if (flightNumber != that.flightNumber) return false;
        if (!arrivalAirport.equals(that.arrivalAirport)) return false;
        return departureAirport.equals(that.departureAirport);
    }

    @Override
    public int hashCode() {
        int result = arrivalAirport.hashCode();
        result = 31 * result + departureAirport.hashCode();
        result = 31 * result + flightNumber;
        return result;
    }
}
