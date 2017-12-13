package statistics;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TestClass {
    public static ArrayList<Long> lista = new ArrayList<>();

    public static ArrayList<Long> getLista() {
        launch();
        return lista;
    }

    private static void launch() {
        for (long i = 0; i < 100; i++) {
            lista.add(i);
            lista.add(1L);
        }
      /*lista.add(2L);
              lista.add(5L);
                      lista.add(1L);
                              lista.add(3L);*/
    }

    public static void main(String[] args){
       /* below code can be used to test Occurences class*/
       /*ArrayList<Long> mylist= getLista();
        Occurences tempList = new Occurences();
        tempList.setList(mylist);
        long wanted=67;
        System.out.println(Occurences.CalculateOccurences(mylist, wanted));*/
        /*MeanArithmetic*/
        /*ArrayList<Long> mylist=getLista();//=null
        MeanArithmetic tempList = new MeanArithmetic();
        tempList.setList(mylist);
        System.out.println(MeanArithmetic.CalculateArithmeticMean(mylist));*/
        /*Median*/
        /*ArrayList<Long> mylist=null;//getLista();//=null
        Median tempList = new Median();
        tempList.setList(mylist);
        System.out.println(Median.CalculateMedian(mylist));*/
        /*Variance*/
        /*ArrayList<Long> mylist=getLista();//=null
        Variance tempList = new Variance();
        tempList.setList(mylist);
        System.out.println(Variance.CalculateVariance(mylist));*/
        /*Standard Deviation*/
        /*ArrayList<Long> mylist=getLista();//=null
        StandardDeviation tempList = new StandardDeviation();
        tempList.setList(mylist);
        System.out.println(StandardDeviation.CalculateStandardDeviation(mylist));*/
        /*Min*/
        /*ArrayList<Long> mylist=getLista();//=null
        Min tempList = new Min();
        tempList.setList(mylist);
        System.out.println(Min.CalculateMin(mylist));*/
        /*max*/
        /*ArrayList<Long> mylist=getLista();//=null
        Max tempList = new Max();
        tempList.setList(mylist);
        System.out.println(Max.CalculateMax(mylist));*/
        /*MeanGeometric*/
        /*ArrayList<Long> mylist=getLista();//=null
        MeanGeometric tempList = new MeanGeometric();
        tempList.setList(mylist);
        System.out.println(MeanGeometric.CalculateGeometricMean(mylist));*/



    }
}
