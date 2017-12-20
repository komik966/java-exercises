package edu.agh.ics.lab3;

import org.apache.log4j.Logger;

public class MathHelper {

    private static Logger log = Logger.getLogger(MathHelper.class);
    public static double PI = 3.14159;

    public static void main(String[] args) {
        log.info(isArithmetic());
        log.info(isArithmetic(1));
        log.info(isArithmetic(1,1));
        log.info(isArithmetic(1,3,5));
        log.info(isArithmetic(1,3,8));
        log.info(isGeometric());
        log.info(isGeometric(1));
        log.info(isGeometric(1,1));
        log.info(isGeometric(1,3,9));
        log.info(isGeometric(0,0,0));
        log.info(isGeometric(1,3,8));
    }

    public static boolean isArithmetic(double... ds) {
        if (ds.length < 2) {
            return true;
        }
        double sub = ds[1] - ds[0];
        for (int i = 1; i < ds.length - 1; i++) {
            if (ds[i + 1] - ds[i] != sub) {
                return false;
            }
        }

        return true;
    }

    public static boolean isGeometric(double... ds) {
        if (ds.length < 2) {
            return true;
        }
        if(ds[0] == 0) {
            return false;
        }
        double div = ds[1] / ds[0];
        for (int i = 1; i < ds.length - 1; i++) {
            if(ds[i] == 0) {
                return false;
            }
            if (ds[i + 1] / ds[i] != div) {
                return false;
            }
        }
        return true;
    }

    public static double harmonicMean(double... ds) {
        return 0.0;
    }
}
