package org.server.calculations.statistics;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Occurences {

    public void setWanted_element(int wanted_element) {
        this.wanted_element = wanted_element;
    }

    int wanted_element;

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    ArrayList<Integer> list;


    /* below function counts occurences of given wanted_element. returns number of occurences, or 0 if none*/
    public static Long CalculateOccurences(ArrayList<Integer> list, int wanted_element) {
        Map<Object, Long> counts = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Long count= counts.get(wanted_element);
        if(count==null) return Long.valueOf(0);
        return count;
    }
}
