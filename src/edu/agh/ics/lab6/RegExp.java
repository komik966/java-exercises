package edu.agh.ics.lab6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        String input = "User password=123344. Some text password=45345345";
        Pattern p = Pattern.compile("(password=)(\\d+)");
        Matcher m = p.matcher(input);
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            System.out.println("Group 1" + m.group(1));
            System.out.println("Group 2 (masking)" + m.group(2));
            m.appendReplacement(result, m.group(1) + "******");
        }
        m.appendTail(result);
        System.out.println(result);
        System.out.println("--------");
        input = "IP=192.168.1.69 Foo IP=5.55.5.5";
        Pattern pi = Pattern.compile("(IP=)([1-2]?[0-9]{1,2}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
        Matcher mi = pi.matcher(input);
        while (mi.find()) {
            System.out.println("Group 1 " + mi.group(1));
            System.out.println("Group 2 " + mi.group(2));
            System.out.println(mi.start());
            System.out.println(mi.end());
        }
        System.out.println("--------");
        input = "ZipCode: 00-921";
        Pattern pii = Pattern.compile("(\\d{2}\\-\\d{3})");
        Matcher mii = pii.matcher(input);
        while (mii.find()) {
            System.out.println(mii.group(1));
        }
    }
}
