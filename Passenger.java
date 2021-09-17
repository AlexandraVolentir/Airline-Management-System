import java.time.LocalDate;

public class Passenger extends Person {
    private Seat preferred_seat;
    private DateAndTime preferred_time;
    private Address destination = new Address();

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
        return super.toString() + "\n" + preferred_time.getYear() + " " + preferred_time.getMonth() + " " + preferred_time.getDay_of_month();
    }
}
