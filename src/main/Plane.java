package src.main;

public class Plane {

    private StringBuilder planeName;
    private StringBuilder company;
    int rows;
    int columns;
    private Seat[][] seats;
    Seat lastAvlSeat;
    int totalSeats;
    int bookedSeats = 0;

    public Plane(StringBuilder name, StringBuilder company, int rows, int columns) {
        setPlaneName(name); setCompany(company);
        setRows(rows); setColumns(columns); 
        seats = new Seat[rows][columns];
        initializeSeats();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int gettotalSeats() {
        return totalSeats;
    }

    public void settotalSeats() {
        this.totalSeats = getColumns() * getRows();
    }

    public void checkPlaneNameForValidity(StringBuilder name) throws Exception {
        if (name.length() > 20) {
            throw new Exception("Your input is invalid. Try again.");
        }
    }

    public StringBuilder getPlaneName() {
        return planeName;
    }

    public void setPlaneName(StringBuilder name) {

        try {
            checkPlaneNameForValidity(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.planeName = name;
    }

    public StringBuilder getCompany() {
        return company;
    }

    public void setCompany(StringBuilder company) {
        try {
            checkPlaneNameForValidity(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.company = company;
    }

    public void initializeSeats() {
        settotalSeats();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat(i, attributeColumn(j), false);
            }
        // lastAvlSeat = seats[0]['A'];
    }

    public char attributeColumn(int column) {
        if (column < columns)
            return (char) (column + 'A');
        return '-';
    }

    public boolean bookSeat() {
        // to be updated
        if (bookedSeats != totalSeats) {
            int row = lastAvlSeat.row;
            int column = lastAvlSeat.column;
            try {
                seats[row][column] = new Seat(row, attributeColumn(column), true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (lastAvlSeat.column == columns - 1 && bookedSeats != totalSeats) {
                lastAvlSeat.column = 'A';
                lastAvlSeat.row++;
            }
            bookedSeats++;
            return true;
        }
        return false;
    }

    public boolean bookSeat(int row, int column) {
        // to be updated
        if (bookedSeats != totalSeats) {
            try {
                seats[row][column] = new Seat(row, attributeColumn(column), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bookedSeats++;
            return true;
        }
        return false;
    }

    public void setLastAvlSeat(Seat lastAvlSeat) {
        this.lastAvlSeat = lastAvlSeat;
    }

    public boolean checkSeatForAvailability(int cur_row, int cur_column) {
        return seats[cur_row][cur_column].row != 0 || seats[cur_row][cur_column].column != '\u0000';
    }
}
