package src.main;

public class Plane {

    private StringBuilder planeName;
    private StringBuilder company;
    int rows;
    int columns;
    private final Seat[][] seats = new Seat[rows][columns]; // 9 for ABC DEF GHI
    Seat lastAvailSeat;
    int totalNumberOfSeats;
    int bookedSeats = 0;
    

    public Plane(StringBuilder name, StringBuilder company, int rows, int columns) {
        setPlaneName(name); setCompany(company);
        setRows(rows); setColumns(columns);
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

    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats() {
        this.totalNumberOfSeats = getColumns()*getRows();
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

    public void initializeSeats(){

        setTotalNumberOfSeats();
        for(int i = 0; i< rows; i++)
            for(int j = 0; j< columns; j++){
                seats[i][j] = new Seat(i, attributeColumn(j), false);
            }
        lastAvailSeat = seats[0]['A'];
    }
    
    public char attributeColumn(int column) {
        if (column < columns)
            return (char) (column + 'A');
        return '-';
    }

    public boolean bookSeat(int row, int column) {
        if(bookedSeats == totalNumberOfSeats){
            return false;
        }
        else{
            ////////////////////////////////////
            if (checkSeatForAvailability(++lastAvailSeat.row, ++lastAvailSeat.column))
                seats[row][column] = new Seat(row, attributeColumn(column), true);
            bookedSeats++;
            return true;
        }
       
    }

    public boolean checkSeatForAvailability(int cur_row, int cur_column) {
        return seats[cur_row][cur_column].row != 0 || seats[cur_row][cur_column].column != '\u0000';
    }
}

