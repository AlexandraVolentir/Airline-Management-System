import java.time.LocalDate;

public class Passenger extends Person {
    private Seat preferred_seat;
    private DateAndTime preferred_time;
    private Address destination;

    public void setDestination(StringBuilder country, StringBuilder city) {
        try {
            destination.setCountry(country);
            destination.setCity(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() {
        try {
            setFirstName("Jonathan");
            setLastName("Smith");
            setSex('m');
            setSSN(153910810);

            Address adr = new Address();
            adr.setApartment(new StringBuilder("Ap23"));
            adr.setCity(new StringBuilder("Iasi"));
            adr.setCountry(new StringBuilder("Romania"));
            adr.setStreet(new StringBuilder("Street"));
            adr.setStreet_number(new StringBuilder("32"));

            setAddress(adr);
            setDOB(LocalDate.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getFirstName() + " " + getLastName());
        System.out.println(getSex() + " " + getSSN() + " " + getDOB().toString());
        System.out.println(getAddress().toString());
    }
}
