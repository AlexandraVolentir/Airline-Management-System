public class Main {
    public static void main(String[] args) {
        CSVReader r;
        try {
            r = new CSVReader("countries.csv");
            Country c = new Country(r, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Passenger p = new Passenger();
        p.test();
    }
}
