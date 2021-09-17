import java.util.Vector;

public class Address {

    private StringBuilder country;
    private StringBuilder city;
    private StringBuilder street;
    private StringBuilder street_number;
    private StringBuilder apartment;

    public StringBuilder getCountry() {
        return country;
    }

    public void setCountry(StringBuilder country) throws Exception {
        if (Country.getCountries().contains(country.toString()))
            this.country = country;
        else
            throw new Exception(country.toString() + " not found in the given country list");
    }

    public StringBuilder getCity() {
        return city;
    }

    public void setCity(StringBuilder city) throws Exception {
        for (Vector<String> line : CSVReader.getInstance().getData()) {
            if (line.contains(city.toString())) {
                this.city = city;
                return;
            }
        }
        throw new Exception(city.toString() + " not found in the given city list");
    }

    public StringBuilder getStreet() {
        return street;
    }

    public void setStreet(StringBuilder street) {
        this.street = new StringBuilder();
        char[] carr = street.toString().toCharArray();
        for (int i = 0; i < carr.length - 1; i++) {
            if (carr[i] == ' ') {
                carr[i + 1] += 32;
            }
            this.street.append(carr[i]);
        }
    }

    public StringBuilder getStreet_number() {
        return street_number;
    }

    public void setStreet_number(StringBuilder street_number) {
        this.street_number = street_number;
    }

    public StringBuilder getApartment() {
        return apartment;
    }

    public void setApartment(StringBuilder apartment) {
        this.apartment = apartment;
    }

    public boolean isValid() {
        return false;
    }

    public String toString() {
        return country + " " + city + " " + street + " " + street_number + " " + apartment;
    }
}
