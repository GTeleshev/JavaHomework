package Seminar3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem2 {
    //    Пусть дан произвольный список целых чисел, удалить из него четные числа
    public static void main(String[] args) {
        List<Integer> List1 = FillList(500, -100, 100);
        System.out.println(List1);
        System.out.println(DeleteEven(List1));
    }

    public static List<Integer> DeleteEven(List<Integer> List0) {
        List<Integer> newList = new ArrayList<>();
        for (int item : List0) {
            if (item % 2 != 0) newList.add(item);
        }
        return newList;
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