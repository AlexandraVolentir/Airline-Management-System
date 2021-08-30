import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Person {
    public StringBuilder first_name = null;
    public StringBuilder last_name = null;
    public char sex = '-';
    public int ssn = 0;
    public LocalDateTime dob =  LocalDateTime.now();
    public Address address = new Address();
}
