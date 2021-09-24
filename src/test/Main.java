package src.test;

import src.main.*;

public class Main {
    public static void main(String[] args) throws Exception {
        CSVReader r = new CSVReader("src\\resources\\csv\\countries.csv");
        Passenger p = new Passenger(r);

        p.setFirstName("Robert");
        p.setLastName("Robertson");
        p.setAddress(new Address(r));

        p.setDestination(new StringBuilder("United Kingdom"), new StringBuilder("York"));
        p.setSSN(12309832);
        p.setSex('m');

        System.out.println(p.getDestination().getCity() + ", " + p.getDestination().getCountry());
        System.out.println(p.toString());

        Ticket t = new Ticket();
        t.setWho(p);

        Flight f = new Flight(new DateAndTime(2021, 12, 3, 7, 4), new DateAndTime(2021, 12, 3, 10, 30), new Plane(new StringBuilder("Plane name"), new StringBuilder("Plane company")));
        f.addTicket(t);
    }
}
