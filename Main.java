public class Main {
    public static void main(String[] args) {
        try {
            Country c = new Country(CSVReader.getInstance(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Passenger p = new Passenger();
        p.test();
    }
}
