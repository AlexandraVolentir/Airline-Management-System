package src.main;
public class Crewmate extends Person {
    public boolean isPilot;
    
    public Crewmate(CSVReader reader) {
    }
    
    public boolean isPilot() {
        return isPilot;
    }

    public void setPilot(boolean pilot) {
        isPilot = pilot;
    }

    @Override
    public void test() {

    }
}
