package org.server.calculations.statistics;

import org.server.calculations.statistics.MeanArithmetic;

import java.util.ArrayList;

public class Variance {

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
    ArrayList<Integer> list;

    /* below function returns Variance, unless list empty (then -1)*/
    public static double CalculateVariance(ArrayList<Integer> list)
    {
        if ((list == null) || list.isEmpty()) return -1;
        double mean = MeanArithmetic.CalculateArithmeticMean(list);
        double temp = 0;
       for(double a :list)
            temp += (a-mean)*(a-mean);
        return temp/(list.size()-1);
    }
}
