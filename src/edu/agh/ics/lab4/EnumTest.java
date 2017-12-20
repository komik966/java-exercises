package edu.agh.ics.lab4;

import org.apache.log4j.Logger;

public class EnumTest {
    private static Logger log = Logger.getLogger(EnumTest.class);

    public static void main(String[] args) {
        for (Month m :
                Month.values()) {
            if(m.getNumberOfDays() == 31) {
                log.info(m);
            }
        }
    }
}
