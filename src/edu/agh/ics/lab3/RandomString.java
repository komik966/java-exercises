package edu.agh.ics.lab3;

import org.apache.log4j.Logger;

import java.util.Random;

public class RandomString {

    private static Logger log = Logger.getLogger(RandomString.class);
    private static int instancesCount = 0;
    private String content;

    public RandomString() {
        instancesCount++;
        Random rand = new Random();
        int length = 4 + rand.nextInt(9);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char)(rand.nextInt(26) + 'a');
            sb.append(c);
        }
        content = sb.toString();
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "RandomString [content=" + content + "]";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            log.info(new RandomString());
        }
    }
}
