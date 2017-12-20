package edu.agh.ics.lab3;


import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class ArrayListExperiments {
    private static Logger log = Logger.getLogger(EuclideanDistance.class);

    private static int SIZE = 100_000_000;

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        List<Integer> listA = new ArrayList<>();
//        log.info("Size: " + listA.size());
//        for (int i = 0; i < SIZE; i++) {
//            listA.add(1);
//        }
//        log.info("Size: " + listA.size());
//        long end = System.currentTimeMillis();
////        log.info("ArrayList : " + (end - start) / 1000.0 + " [s]");
//
//        long start = System.currentTimeMillis();
//        List<Integer> listB = new ArrayList<>(SIZE);
//        log.info("Size: " + listB.size());
//        for (int i = 0; i < SIZE; i++) {
//            listB.add(1);
//        }
//        log.info("Size: " + listB.size());
//        long end = System.currentTimeMillis();
//        log.info("ArrayList : " + (end - start) / 1000.0 + " [s]");

        long start = System.currentTimeMillis();
        List<Integer> listC = new LinkedList<>();
        log.info("Size: " + listC.size());
        for (int i = 0; i < SIZE; i++) {
            listC.add(1);
        }
        log.info("Size: " + listC.size());
        long end = System.currentTimeMillis();
        log.info("ArrayList : " + (end - start) / 1000.0 + " [s]");
    }
}
