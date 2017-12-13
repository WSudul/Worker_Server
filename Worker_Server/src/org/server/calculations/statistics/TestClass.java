package org.server.calculations.statistics;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TestClass {
    public static ArrayList<Integer> lista = new ArrayList<>();

    public static ArrayList<Integer> getLista() {
        launch();
        return lista;
    }

    private static void launch() {
      /*  for (int i = 0; i < 100; i++) {
            lista.add(i);
            lista.add(1);
        }*/
      lista.add(2);
              lista.add(5);
                      lista.add(1);
                              lista.add(3);
    }

    public static void main(String[] args){
       /* below code can be used to test Occurences class*/
       /*ArrayList<Integer> mylist= getLista();
        Occurences tempList = new Occurences();
        tempList.setList(mylist);
        int wanted=67898765;
        System.out.println(Occurences.CalculateOccurences(mylist, wanted));*/

        /* below code can be used to test MeanArithmetic class*/
        /*ArrayList<Integer> mylist=getLista();//=null
        MeanArithmetic tempList = new MeanArithmetic();
        tempList.setList(mylist);
        System.out.println(MeanArithmetic.CalculateArithmeticMean(mylist));*/

        /*Median*/
        /*ArrayList<Integer> mylist=getLista();//=null
        Median tempList = new Median();
        tempList.setList(mylist);
        System.out.println(Median.CalculateMedian(mylist));*/

        /*Variance*/
        /*ArrayList<Integer> mylist=getLista();//=null
        Variance tempList = new Variance();
        tempList.setList(mylist);
        System.out.println(Variance.CalculateVariance(mylist));*/

        /*STandard Deviation*/
        /*ArrayList<Integer> mylist=getLista();//=null
        StandardDeviation tempList = new StandardDeviation();
        tempList.setList(mylist);
        System.out.println(StandardDeviation.CalculateStandardDeviation(mylist));*/


        /*Ola TO DO TUESDAY:
        check calculations
        add means (to functions, not to life)
        max
        min
        dominanty
        kwantyle
        makarena
         */



    }
}
