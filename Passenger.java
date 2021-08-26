import java.util.Date;



public class Passenger {
    private StringBuilder first_name, last_name, personal_id,
            nationality, email_address, telephone_number, address, zip_code;
    private char sex;
    private Date date_of_birth;
    private Boolean criminal_record;
    private int frequent_flyer_number;

    public static boolean isValidEmailAddress(String email) {

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();

    }

    public StringBuilder getFirst_name() {
        return first_name;
    }

    public void setFirst_name(StringBuilder first_name) {
        this.first_name = first_name;
    }

    public StringBuilder getLast_name() {
        return last_name;
    }

    public void setLast_name(StringBuilder last_name) {
        this.last_name = last_name;
    }

    public StringBuilder getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(StringBuilder personal_id) {
        this.personal_id = personal_id;
    }

    public StringBuilder getNationality() {
        return nationality;
    }

    public void setNationality(StringBuilder nationality) {
        this.nationality = nationality;
    }

    public StringBuilder getEmail_address() {
        return email_address;
    }

    public void setEmail_address(StringBuilder email_address) {
        this.email_address = email_address;
    }

    public StringBuilder getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(StringBuilder telephone_number) {
        this.telephone_number = telephone_number;
    }

    public StringBuilder getAddress() {
        return address;
    }

    public void setAddress(StringBuilder address) {
        this.address = address;
    }

    public StringBuilder getZip_code() {
        return zip_code;
    }

    public void setZip_code(StringBuilder zip_code) {
        this.zip_code = zip_code;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Boolean getCriminal_record() {
        return criminal_record;
    }

    public void setCriminal_record(Boolean criminal_record) {
        this.criminal_record = criminal_record;
    }

    public int getFrequent_flyer_number() {
        return frequent_flyer_number;
    }

    public void setFrequent_flyer_number(int frequent_flyer_number) {
        this.frequent_flyer_number = frequent_flyer_number;
    }



}
