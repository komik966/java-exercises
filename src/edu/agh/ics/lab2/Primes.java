package edu.agh.ics.lab2;

import org.apache.log4j.Logger;

import java.util.Random;

public class Primes {

    private static Logger log = Logger.getLogger(ArrayExperiments.class);

    private static int[] generateArray(int size) {
        int[] tmp = new int[size];
        Random rand = new Random();
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = rand.nextInt() + 1;
        }

        return tmp;
    }
}
