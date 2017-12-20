package edu.agh.ics.lab2;

import org.apache.log4j.Logger;

public class SwapNumbers {

    private static Logger log = Logger.getLogger(SwapNumbers.class);

    public static void main(String[] args) {
        if (args.length != 2) {
            log.error("Usage: <number A> <number B>");
            System.exit(-1);
        }

        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            log.info("x=" + x + ", y=" + y);
            x = x ^ y;
            y = x ^ y;
            x = x ^ y;
            log.info("x=" + x + ", y=" + y);
        } catch (NumberFormatException ex) {
            log.error("Invalid arguments - should e an integer: " + args[0] + ", " + args[1]);
            System.exit(-2);
        }
    }
}
