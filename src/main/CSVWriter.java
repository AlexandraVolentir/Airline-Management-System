package src.main;

import java.io.File;
import java.util.Vector;

public class CSVWriter {
    private File file;
    private static Vector<String[]> data = null;

    public CSVWriter(String fileName) throws Exception {
        if (fileName.contains(".csv")) {
            file = new File(fileName);
        } else {
            file = new File(fileName + ".csv");
        }

        if (!file.canRead() || !file.canWrite()) {
            throw new Exception("Cannot access file " + file.toString());
        }
    }

    public void insertAll(String[][] ele) {
        
    }

    public void removeAt(int index) {

    }

    public int findLine(String ele) {
        return 0;
    }

    public int findLine(String[] ele) {
        return 0;
    }

    public String[] getLine(int index) {
        return new String[0];
    }
}
