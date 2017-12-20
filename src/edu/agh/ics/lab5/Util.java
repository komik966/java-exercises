package edu.agh.ics.lab5;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    private static Logger log = Logger.getLogger(Util.class);

    public static <T extends Serializable> Map<T, Integer> getFrequencies(List<T> list) { // <- serializable tylko dla przykładu bounded
        Map<T, Integer> map = new HashMap<>();
        for (T element :
                list) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }

    public static Map<Serializable, Integer> getFrequenciesWildcard(List<? extends Serializable> list) {
        Map<Serializable, Integer> map = new HashMap<>();
        for (Serializable element :
                list) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }

    public static double avg(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number :
                list) {
            sum += number.doubleValue();
        }
        return sum / list.size();
    }

    public static void main(String[] args) {
        List<Integer> ilist = Arrays.asList(1, 3, 1, 4, 3, 3, 3, 2, 1, 1); // <- połączenie var args i generics
        List<String> slist = Arrays.asList("ala", "ola", "ala", "ola", "ola", "ala", "ola", "ala", "ala");
        List<Pair<String>> plist = Arrays.asList(new Pair<String>("Jan", "Kowalski"), new Pair<String>("Jan", "Kowalski"), new Pair<String>("Jan", "Nowak"));

        Map<Serializable, Integer> map = Util.getFrequenciesWildcard(ilist);
        for (Map.Entry<Serializable, Integer> entry :
                map.entrySet()) {
            log.info(entry.getKey() + " : " + entry.getValue());
        }

        Map<Serializable, Integer> smap = Util.getFrequenciesWildcard(slist);
        for (Map.Entry<Serializable, Integer> entry :
                smap.entrySet()) {
            log.info(entry.getKey() + " : " + entry.getValue());
        }

//        Map<Pair<String>, Integer> pmap = Util.getFrequenciesWildcard(plist);
//        for (Map.Entry<Pair<String>, Integer> entry :
//                pmap.entrySet()) {
//            log.info(entry.getKey() + " : " + entry.getValue());
//        }
        log.info("Średnia: " + avg(ilist));

    }
}
