package edu.agh.ics.lab2;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class ArrayExperiments {

    private static Logger log = Logger.getLogger(ArrayExperiments.class);

    private static int[] generateArray(int size, int max) {
        int[] tmp = new int[size];
        Random rand = new Random();
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = rand.nextInt(max) + 1;
        }

        return tmp;
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private static int findMaxIdx(int[] arr) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                idx = i;
            }
        }
        return idx;
    }

    private static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = generateArray(50, 100);
        log.info(Arrays.toString(array));
        log.info(findMax(array));
        log.info(findMaxIdx(array));
        log.info(findMin(array));
    }
}
