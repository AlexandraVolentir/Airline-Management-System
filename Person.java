import java.time.LocalDate;
import java.util.regex.Pattern;

public class Person {
    private String firstName;
    private String lastName;
    private char sex;
    private int SSN;
    private LocalDate DOB;
    private Address address;

    protected void setFirstName(String newFirstName) throws Exception {
        if (!Pattern.matches("^[A-Z][a-z-]{3,30}$", newFirstName)) {
            throw new Exception("First name(\"" + newFirstName + "\") is invalid");
        }
        firstName = newFirstName;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected void setLastName(String newLastName) throws Exception {
        if (!Pattern.matches("^[A-Z][a-z-]{3,30}$", newLastName)) {
            throw new Exception("Last name(\"" + newLastName + "\") is invalid");
        }
        lastName = newLastName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected void setSex(char newSex) throws Exception {
        if (!Pattern.matches("[mf]", String.valueOf(newSex))) {
            throw new Exception("Sex(\"" + newSex + "\") is invalid");
        }
        sex = String.valueOf(newSex).toLowerCase().charAt(0);
    }

    protected char getSex() {
        return sex;
    }

    protected void setSSN(int newSSN) {
        // TODO: add some verification
        SSN = newSSN;
    }

    protected int getSSN() {
        return SSN;
    }

    protected void setDOB(LocalDate newDOB) throws Exception {
        if (newDOB.isAfter(LocalDate.now())) {
            throw new Exception(newDOB.toString() + " is not a valid Date of Birth");
        }
        DOB = newDOB;
    }

    protected LocalDate getDOB() {
        return DOB;
    }

    protected void setAddress(Address newAddress) {
        address = newAddress;
    }

    protected Address getAddress() {
        return address;
    }
}
