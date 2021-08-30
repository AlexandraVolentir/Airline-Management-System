public class Address {

    private StringBuilder country;
    private StringBuilder city;
    private StringBuilder street;
    private StringBuilder street_number;
    private StringBuilder apartment;
    private Country obj;

    public StringBuilder getCountry() {
        return country;
    }

    public void setCountry(StringBuilder country) {
        //this.country = country;
    }

    public StringBuilder getCity() {
        return city;
    }

    public void setCity(StringBuilder city) {
        this.city = city;
    }

    public StringBuilder getStreet() {
        return street;
    }

    public void setStreet(StringBuilder street) {
        this.street = street;
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
}
