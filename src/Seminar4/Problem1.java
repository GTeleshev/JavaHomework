package Seminar4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import static java.lang.System.nanoTime;

public class Problem1 {
//    Пусть дан LinkedList с несколькими элементами.
//    Реализуйте метод, который вернет “перевернутый” список.
    public static void main(String[] args) {
        int size = 20;
        int max = 50;
        //С новым листом
        LinkedList<Integer> def = FillList(size, max);
        System.out.println("Исходный LinkedList (1): " + def);
        long start = nanoTime();
        LinkedList<Integer> rev = NewRevertedList(def);
        long end = nanoTime();
        System.out.println("Обратный LinkedList (1): " + rev);
        System.out.println("1st Time: " + (end - start) + " ns");
        //Без создания нового листа
        LinkedList<Integer> def1 = FillList(size, max);
        System.out.println("Исходный LinkedList (2): " + def1);
        start = nanoTime();
        RevertList(def1);
        end = nanoTime();
        System.out.println("Обратный LinkedList (2): " + def1);
        System.out.println("2nd Time: " + (end - start) + " ns");
        //С использованием коллекций
        LinkedList<Integer> def2 = FillList(size, max);
        System.out.println("Исходный LinkedList (3): " + def2);
        start = nanoTime();
        RevertListColl(def2);
        end = nanoTime();
        System.out.println("Обратный LinkedList (3): " + def2);
        System.out.println("2nd Time: " + (end - start) + " ns");
    }
    public static LinkedList<Integer> FillList(int size, int max){
        LinkedList<Integer> defList = new LinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < size ; i++) {
            defList.add(rand.nextInt(max));
        }
        return defList;
    }
    public static LinkedList<Integer> NewRevertedList(LinkedList<Integer> listToRevert){
        LinkedList<Integer> newList = new LinkedList<>();
        int size = listToRevert.size();
        for (int i = size - 1; i >= 0; i--) {
            newList.add(listToRevert.get(i));
        }
        return newList;
    }
    public static void RevertList(LinkedList<Integer> listToRevert){
        int size = listToRevert.size();
        int distance = size;
        int i = 0;
        while (distance > 1){
            int tmp = listToRevert.get(i);
            listToRevert.set(i, listToRevert.get(size - i - 1));
            listToRevert.set(size - i - 1, tmp);
            i++;
            distance = size - 2 * i;
        }
    }
    public static void RevertListColl(LinkedList<Integer> listToRevert){
        Collections.reverse(listToRevert);
    }
}
