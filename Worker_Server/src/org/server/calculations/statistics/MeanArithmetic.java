package org.server.calculations.statistics;

import java.util.ArrayList;

public class MeanArithmetic {

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
    ArrayList<Integer> list;

    /*below function calculates mean from given integer array. returns -1 if array empty
    * TO DISCUSS: what if actual mean is -1 ?*/
    public static double CalculateArithmeticMean(ArrayList<Integer> list) {
        double sum = 0;
       if ((list == null) || list.isEmpty()) return -1;
       // if(0 == size) return -1;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum / list.size();
    }
}
