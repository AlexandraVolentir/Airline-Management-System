import java.security.KeyStore;

public class Seat {
    static final int ROWS = 32;
    static final int COLUMNS = 9;
    static private Tuple[][] seats = new Tuple[ROWS][COLUMNS]; // 9 for ABC DEF GHI
    private Tuple seat;

    public Seat() {

    }

    public void findNextAvailableSeat()
    {

    }

    public char atributeColumn(int column)
    {
        switch(column) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            case 7:
                return 'H';
            case 8:
                return 'I';
            default:
                return '-';

        }
    }

    public void bookSeat(int row, int column)
    {
        if (checkSeatForAvailability(row, column))

        seats[row][column] = new Tuple(row, atributeColumn(column), true);
    }

    public boolean checkSeatForAvailability(int cur_row, int cur_column)
    {
        if (seats[cur_row][cur_column].row == 0 && seats[cur_row][cur_column].column == '\u0000')
            return false;
        return true;
    }
}
