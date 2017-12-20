package edu.agh.ics.lab4;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

public class MapExperiments {
    private static Logger log = Logger.getLogger(MapExperiments.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            log.error("Provide at least one argument");
        }
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (map.containsKey(arg)) {
                map.put(arg, map.get(arg) + 1);
            } else {
                map.put(arg, 1);
            }
        }
        for (Map.Entry<String, Integer> element :
                map.entrySet()) {
            log.info(element.getKey() + " : " + element.getValue());
        }
    }
}
