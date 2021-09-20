package src.main;
public class Ticket {
    private Passenger who;
    private DateAndTime departure;
    private DateAndTime landing;
    private Seat confirmed_seat;
    public boolean isValid;

    public Passenger getWho() {
        return who;
    }

    public void setWho(Passenger who) {
        this.who = who;
    }

    public DateAndTime getDeparture() {
        return departure;
    }

    public void setDeparture(DateAndTime departure) {
        this.departure = departure;
    }

    public DateAndTime getLanding() {
        return landing;
    }

    public void setLanding(DateAndTime landing) {
        this.landing = landing;
    }

    public Seat getConfirmed_seat() {
        return confirmed_seat;
    }

    public void setConfirmed_seat(Seat confirmed_seat) {
        this.confirmed_seat = confirmed_seat;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
