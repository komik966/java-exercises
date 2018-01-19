package edu.agh.ics.lab6;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NioTest {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("Ussage ...");
            System.exit(-1);
        }
        String sourceFile = args[0];
        String destination = args[1];
        Path sourcePath = Paths.get(sourceFile);
        if(Files.notExists(sourcePath)) {

        }
    }
}
