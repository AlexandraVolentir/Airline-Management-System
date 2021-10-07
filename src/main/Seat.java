public class Seat{

    public int row;
    public char column;
    public boolean booked;

    public Seat(int row, char column, boolean booked)
    {
        setRow(row);
        setColumn(column);
        setBooked(booked);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public void bookSeat(Seat seat)
    {
        seat.booked = true;
    }

    public void unbookSeat(Seat seat)
    {
        seat.booked = false;
    }

}
