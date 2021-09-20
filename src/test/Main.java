package src.test;

import src.main.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Passenger p = new Passenger();
        p.setFirstName("Robert");
        p.setLastName("Robertson");
        p.setAddress(new Address());

        p.setDestination(new StringBuilder("United Kingdom"), new StringBuilder("York"));
        p.setSSN(12309832);
        p.setSex('m');
        
        System.out.println(p.toString());
    }
}
