package src.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

public class CSVReader {
    private File file;
    private Vector<String[]> data = new Vector<>();

    public CSVReader(String fileName) throws Exception {
        if (!fileName.contains(".csv")) {
            throw new Exception(fileName + " is not a .csv");
        }
        file = new File(fileName);
        if (!file.exists() || file.isDirectory()) {
            throw new Exception(fileName + " does not exist or is a directory");
        }

        readFile();
    }

    private void readFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String line = null;
        do {
            try {
                line = br.readLine();
                if (line.compareTo("") != 0) {
                    String[] lineContent = line.split(",");
                    data.add(lineContent);
                }
            } catch (Exception e) {
                if (data.size() < 2) // line will eventually be null because of the do-while
                    e.printStackTrace();
            }
        } while (line != null);

        try {
            br.close();
        } catch (Exception e) {
        }
    }

    public void printAll() {
        for (String[] row : data) {
            for (String str : row) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public Vector<String[]> getData() {
        return data;
    }
}