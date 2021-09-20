package src.main;
import java.security.KeyStore;

public class Seat {
    static final int ROWS = 32;
    static final int COLUMNS = 9;
    static private Tuple[][] seats = new Tuple[ROWS][COLUMNS]; // 9 for ABC DEF GHI
    private Tuple seat;

    public Seat() {

    }

    public void findNextAvailableSeat() {

    }

    public char atributeColumn(int column) {
        if (column < COLUMNS)
            return (char) (column + 'A');
        return '-';
    }

    public void bookSeat(int row, int column) {
        if (checkSeatForAvailability(row, column))
            seats[row][column] = new Tuple(row, atributeColumn(column), true);
    }

    public boolean checkSeatForAvailability(int cur_row, int cur_column) {
        if (seats[cur_row][cur_column].row == 0 && seats[cur_row][cur_column].column == '\u0000')
            return false;
        return true;
    }
}
