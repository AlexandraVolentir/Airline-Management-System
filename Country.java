import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Country {
    public static List<String> countryList = new LinkedList<String>();

    public Country() {
        insertInListTheCountries();
    }

    public void insertInListTheCountries() {
        // buffered reading
        countryList.clear();

        File file = new File("countries");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.compareTo("") != 0)
                    countryList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listTheCountries() {
        for (String country : countryList) {
            System.out.println(country);
        }
        System.out.println("Number of countries: " + countryList.size());
    }

}
