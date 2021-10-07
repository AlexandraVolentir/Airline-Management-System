package src.main;

import java.io.*;
import java.util.Arrays;
import java.util.Vector;

/**
 * Class that allows read/write operations on csv files.
 * <p>
 * The inner {@link #data} is cached, so that there are no unnecessary or
 * accidental read operations, and is only changed upon calling one of the
 * following methods: {@link #append}, {@link #overwrite}, {@link #removeAt}, or
 * {@link #clear}.
 * </p>
 */
public class CSVReader {
    private File file;
    private Vector<String[]> data = null;
    private boolean changed = false;
    final private String cwd = "src\\resources\\csv\\";

    public CSVReader(String fileName) throws Exception {
        if (fileName.contains(".csv")) {
            file = new File(cwd + fileName);
        } else {
            file = new File(cwd + fileName + ".csv");
        }

        if (!file.canRead() || !file.canWrite()) {
            throw new Exception("Cannot read/write file " + fileName);
        }
        if (!file.exists() || file.isDirectory()) {
            throw new Exception(fileName + " does not exist or is a directory");
        }

        readFile();
    }

    /**
     * Only reads the current file if:
     * <ul>
     * <li>it's the first time it's being read</li>
     * <li>the file has been modified</li>
     * </ul>
     */
    public void readFile() {
        if (data == null || changed) {
            data = new Vector<String[]>();
        } else if (!changed) {
            return;
        }

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
                if (data == null) // line will eventually be null because of the do-while
                    e.printStackTrace();
            }
        } while (line != null);

        try {
            br.close();
        } catch (Exception e) {
        }

        changed = false;
    }

    /**
     * Inserts a new line at the end of the file, without checking if it has a csv
     * format
     * 
     * @param line Line to be inserted
     */
    public void append(String line) {
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(file, true));
            wr.write(line);
            wr.append('\n');

            changed = true;
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserts multiple lines at the end of the file, best paired with the
     * {@link #getData} method called on another instance
     * 
     * @param lines Lines to be inserted
     */
    public void append(String[] lines) {
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(file, true));
            for (String line : lines) {
                wr.write(line);
                wr.append('\n');
            }

            changed = true;
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void overwrite(String[] lines) {
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(file));
            for (String line : lines) {
                wr.write(line + '\n');
            }

            changed = true;
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAt(int index) {
        if (changed) {
            readFile();
        }
        data.remove(index);

        String[] out = new String[data.size()];
        int j = 0;
        for (String[] line : data) {
            String tmp = new String();

            for (int i = 0; i < line.length - 1; i++) {
                tmp += line[i] + ",";
            }
            tmp += line[line.length - 1];

            out[j++] = tmp;
        }

        overwrite(out);
        changed = true;
    }

    public int findFirstLine(String line) {
        if (changed) {
            readFile();
        }
        for (int i = 0; i < data.size(); i++) {
            if (Arrays.compare(data.elementAt(i), line.split(",")) == 0) {
                return i;
            }
        }
        return -1;
    }

    public String[] getLine(int index) {
        if (changed) {
            readFile();
        }

        return data.elementAt(index);
    }

    public void printAll() {
        for (String[] row : data) {
            for (String str : row) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public void clear() {
        overwrite(new String[0]);
        changed = true;
    }

    public Vector<String[]> getData() {
        return data;
    }
}