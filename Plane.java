public class Plane {

    private StringBuilder name;
    private StringBuilder company;

    public void checkTheNameForValidity(StringBuilder name) throws Exception {
        if(name.length() > 20) {
            throw new Exception("Your input is invalid. Try again.");
        }
    }

    public StringBuilder getName() {
        return name;
    }

    public void setName(StringBuilder name)  {

        try{
            checkTheNameForValidity(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.name = name;
    }

    public StringBuilder getCompany() {
        return company;
    }

    public void setCompany(StringBuilder company) {
        try{
            checkTheNameForValidity(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.company = company;
    }
}
