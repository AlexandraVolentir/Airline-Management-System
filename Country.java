import java.util.TreeSet;
import java.util.Vector;

public class Country {
    public static TreeSet<String> countryList = new TreeSet<String>();

    public Country(CSVReader r, int where) {
        for (Vector<String> line : r.data) {
            countryList.add(line.get(where));
        }
    }

    public void listTheCountries() {
        for (String country : countryList) {
            System.out.println(country);
        }
        System.out.println("Number of countries: " + countryList.size());
    }
    
    public boolean checkIfCountryInList(String country)
    {
        if(countryList.contains(country))
            return true;
        return false;
    }

}
