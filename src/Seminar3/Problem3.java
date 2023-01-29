package Seminar3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem3 {
    //    Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее
//    ариф из этого списка.
    public static void main(String[] args) {
        List<Integer> List1 = FillList(500, -100, 200);
        System.out.println(List1);
        double[] metrics = MinMaxAv(List1);
        System.out.println("Minimum: " + metrics[0]);
        System.out.println("Maximum: " + metrics[1]);
        System.out.println("Average: " + metrics[2]);
    }

    public static double[] MinMaxAv(List<Integer> List0) {
        double[] minmaxav = new double[3];
        minmaxav[0] = List0.get(0);
        minmaxav[1] = List0.get(0);
        minmaxav[2] = 0;
        int count = List0.size();
        for (int item : List0) {
            minmaxav[2] += item;
            if (minmaxav[0] > item) minmaxav[0] = item;
            if (minmaxav[1] < item) minmaxav[1] = item;
        }
        minmaxav[2] = (count != 0) ? minmaxav[2] / count : 0;
        return minmaxav;
    }

    public static List<Integer> FillList(int Size, int Min, int Max) {
        Random rand = new Random();
        List<Integer> OutList = new ArrayList<>();
        for (int i = 0; i < Size; i++) {
            OutList.add(rand.nextInt(Max - Min) + Min);
        }
        return OutList;
    }
}
