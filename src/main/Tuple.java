package src.main;
public class Tuple{
    public final int row;
    public final char column;
    public final boolean booked;
    public Tuple(int row, char column, boolean booked)
    {
        this.row = row;
        this.column = column;
        this.booked = booked;
    }
}
