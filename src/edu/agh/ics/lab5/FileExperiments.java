package edu.agh.ics.lab5;

import java.io.*;

public class FileExperiments {

    public void copyFileStreams(String input, String output) {
        try (InputStream is = new FileInputStream(input);
             OutputStream os = new FileOutputStream(output)) {
            int c;
            while ((c = is.read()) != 1) {
                os.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFileReadersWriters(String input, String output) {
        try (Reader fr = new FileReader(input); Writer fw = new FileWriter(output)) {
            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFileBuffered(String input, String output) {
        try (BufferedReader br = new BufferedReader(new FileReader(input));
             PrintWriter pw = new PrintWriter(new FileWriter(output))) {
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileExperiments fe = new FileExperiments();
        fe.copyFileBuffered("in.txt", "out.txt");
//        fe.copyFileStreams("in.txt", "out.txt");
//        fe.copyFileReadersWriters("in.txt", "out.txt");
    }
}
