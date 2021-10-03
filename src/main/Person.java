package src.main;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

abstract class Person {
    private String firstName;
    private String lastName;
    private char sex;
    private int SSN;
    private LocalDate DOB;
    private Address address;
    protected CSVReader reader;

    public Person(CSVReader reader) {
        this.reader = reader;
    }

    public void setFirstName(String newFirstName) throws Exception {
        if (!Pattern.matches("^([A-Z]+[a-z]{1,9}([/-]?[A-Z][a-z]{1,9}){0,4})$", newFirstName)) {
            throw new Exception("First name(\"" + newFirstName + "\") is invalid");
        }
        firstName = newFirstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String newLastName) throws Exception {
        if (!Pattern.matches("^([A-Z]+[a-z]{1,9}([/-]?[A-Z][a-z]{1,9}){0,4})$", newLastName)) {
            throw new Exception("Last name(\"" + newLastName + "\") is invalid");
        }
        lastName = newLastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSex(char newSex) throws Exception {
        if (!Pattern.matches("[mf]", String.valueOf(newSex))) {
            throw new Exception("Sex(\"" + newSex + "\") is invalid");
        }
        sex = String.valueOf(newSex).toLowerCase().charAt(0);
    }

    public char getSex() {
        return sex;
    }

    public void setSSN(int newSSN) {
        SSN = newSSN;
    }

    public int getSSN() {
        return SSN;
    }

    public void setDOB(LocalDate newDOB) throws Exception {
        if (newDOB.isAfter(LocalDate.now())) {
            throw new Exception(newDOB.toString() + " is not a valid Date of Birth");
        }
        DOB = newDOB;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setAddress(Address newAddress) {
        address = newAddress;
    }

    public Address getAddress() {
        return address;
    }

    public String toString() {
        return firstName + " " + lastName + "\n" + sex + " " + SSN + " "
                + (Objects.isNull(DOB) ? "null" : DOB.toString()) + "\n"
                + (Objects.isNull(address) ? "null" : address.toString());
    }

    public abstract void test();
}
