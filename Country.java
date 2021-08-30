import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Country {
    public List<String> countries =new LinkedList<String>();

    public Country() {
        insertInListTheCountries();
    }

    public void insertInListTheCountries() {
        // buffered reading
        countries.clear();

        File file = new File("countries");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                //countries.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listTheCountries()
    {
        for(String country:countries)
        {
            System.out.println(country);
        }
    }

}
