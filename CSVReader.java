import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

public class CSVReader {
    private File file;
    public Vector<Vector<String>> data = new Vector<Vector<String>>();

    CSVReader(String fileName) throws Exception {
        if (!fileName.contains(".csv")) {
            throw new Exception(fileName.toString() + " is not a .csv");
        }
        file = new File(fileName);

        readFile();
    }

    private void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                if (line.compareTo("") != 0 && lineCount != 0) {
                    String[] insertMe = line.split(",");
                    Vector<String> lineContent = new Vector<>();
                    
                    for (String str : insertMe) {
                        lineContent.add(str);
                    }
                    data.add(lineContent);
                }
                lineCount++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printAll() {
        for (Vector<String> row : data) {
            for (String str : row) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}