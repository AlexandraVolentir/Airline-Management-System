package src.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;

public class CSVWriter {
    private File file;
    private Vector<String[]> data = null;
    private boolean changed = false;

    public CSVWriter(String fileName) throws Exception {
        final String cwd = "src\\resources\\csv\\";

        if (fileName.contains(".csv")) {
            file = new File(cwd + fileName);
        } else {
            file = new File(cwd + fileName + ".csv");
        }

        if (!file.exists() || !file.canRead() || !file.canWrite()) {
            throw new Exception("Cannot access file " + file.toString());
        }
    }

    public void append(String ele) {
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(file, true));
            wr.write(ele);
            wr.append('\n');

            changed = true;
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void append(String[] ele) {
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(file, true));
            for (String line : ele) {
                wr.write(line);
                wr.append('\n');
            }

            changed = true;
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void overwrite(String[] ele) {
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(file));
            for (String line : ele) {
                wr.write(line);
            }

            changed = true;
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAt(int index) {
        if (data == null || changed == false) {
            try {
                CSVReader r = new CSVReader(file.toString());
                data = r.getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void clear() {
        file.delete();
    }

    public int findLine(String[] ele) {
        return 0;
    }

    public String[] getLine(int index) {
        return new String[0];
    }
}
