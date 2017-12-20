package edu.agh.ics.lab3;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class EuclideanDistance<T extends Number> implements Distance<T> {
    private static Logger log = Logger.getLogger(EuclideanDistance.class);

    @Override
    public double distance(List<T> vectorA, List<T> vectorB) throws NotMatchingDimensionsException {
        if (vectorA.size() != vectorB.size()) {
            throw new NotMatchingDimensionsException(vectorA.size() + " not matches " + vectorB.size());
        }
        double sum = 0;
        for (int i = 0; i < vectorA.size(); i++) {
            sum += Math.pow(vectorA.get(i).doubleValue() - vectorB.get(i).doubleValue(), 2);
        }
        return Math.sqrt(sum);
    }

    public static void main(String[] args) {
        List<Integer> vectorA = Arrays.asList(0, 0);
        List<Integer> vectorB = Arrays.asList(1, 1);
        EuclideanDistance<Integer> ed = new EuclideanDistance<>();

        try {
            log.info(ed.distance(vectorA, vectorB));
        } catch (NotMatchingDimensionsException e) {
            log.error(e);
        }
    }
}
