package org.server.calculations.statistics;

import java.util.ArrayList;

public class StandardDeviation {

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
    ArrayList<Integer> list;

    static double CalculateStandardDeviation(ArrayList<Integer> list)
    {
        if ((list == null) || list.isEmpty()) return -1;
        return Math.sqrt(Variance.CalculateVariance(list));
    }
}
