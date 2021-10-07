package src.test;

import src.main.*;

public class Main {
    public static void main(String[] args) {
        Test t = new Test();
        try {
            t.testPassenger();
            t.testCSV();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Test {
        private void testPassenger() throws Exception {
            CSVReader r = new CSVReader("countries.csv");
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

            Flight f = new Flight(new DateAndTime(2021, 12, 3, 7, 4), new DateAndTime(2021, 12, 3, 10, 30),
                    new Plane(new StringBuilder("Plane name"), new StringBuilder("Plane company")));
            f.addTicket(t);
        }

        private void testCSV() throws Exception {
            CSVReader r = new CSVReader("test.csv");
            r.clear();
            String test = "Test, append";
            r.append(test);
            r.append(new String[] { "country,city,digits", "united kingdom,london,123", "romania,bucharest,456" });
            System.out.println(r.findFirstLine("country,city,digits"));
            for (String string : r.getLine(2)) {
                System.out.println(string);
            }
            r.removeAt(2);
        }
    }
}
