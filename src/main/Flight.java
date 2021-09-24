package src.main;

import java.util.Vector;

public class Flight {
    private DateAndTime start_date;
    private DateAndTime arrival_date;
    // private AvailableSeat seats;
    private Vector<Ticket> people = new Vector<>();
    private Plane plane;

    public Flight(DateAndTime start, DateAndTime end, Plane p) {
        start_date = start;
        arrival_date = end;
        plane = p;
    }

    public void addTicket(Ticket p) {
        people.add(p);
    }

    public Vector<Ticket> getPeople() {
        return people;
    }
}
