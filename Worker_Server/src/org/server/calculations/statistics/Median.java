package org.server.calculations.statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Median {


    public void setList(ArrayList<Integer> list) {
        Median.list = list;
    }
    static ArrayList<Integer> list;


    private static void sort(){

        Collections.sort(list, new CustomComparator());
    }

    public static double CalculateMedian(ArrayList<Integer> list) {
        if ((list == null) || list.isEmpty()) return -1;
        sort();
        int middle = list.size()/2;
        if (list.size()%2 == 1) {
            return list.get(middle);
        } else {
            return (list.get(middle - 1) + list.get(middle)) / 2.0;
        }
    }
}
