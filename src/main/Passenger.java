package src.main;

import java.util.Objects;

public class Passenger extends Person {
    private Seat preferred_seat;
    private DateAndTime preferred_time;
    private Address destination;

    public Passenger(CSVReader reader) {
        destination = new Address(reader);
    }

    public void setDestination(StringBuilder country, StringBuilder city) {
        try {
            destination.setCountry(country);
            destination.setCity(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Address getDestination() {
        return destination;
    }

    public String toString() {
        return super.toString() + "\n"
                + (Objects.isNull(preferred_time) ? "null"
                        : preferred_time.getYear() + " " + preferred_time.getMonth() + " "
                                + preferred_time.getDay_of_month())
                + " " + (Objects.isNull(preferred_seat) ? "null" : "seat ok");
    }

    public void test() {
    }
}