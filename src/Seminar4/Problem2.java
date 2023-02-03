package Seminar4;
import Seminar4.Problem1;

import java.util.LinkedList;

public class Problem2 {
//    Реализуйте очередь с помощью LinkedList со следующими методами:
//    enqueue() - помещает элемент в конец очереди,
//    dequeue() - возвращает первый элемент из очереди и удаляет его,
//    first() - возвращает первый элемент из очереди, не удаляя
    public static void main(String[] args) {
        int size = 20;
        int max = 50;
        //Новый лист
        LinkedList<Integer> def = Problem1.FillList(size, max);
        System.out.println(def);
        //enqueue
        enqueue(def, 35);
        System.out.println(def);
        //dequeue
        System.out.println("Первый элемент к удалению: " + dequeue(def));
        System.out.println(def);
        //first
        System.out.println("Первый элемент: " + first(def));
    }
    public static void enqueue(LinkedList<Integer> list0, int lastElem){
        list0.add(lastElem);
    }
    public static int dequeue(LinkedList<Integer> list0){
        int frst = list0.getFirst();
        list0.removeFirst();
        return frst;
    }
    public static int first(LinkedList<Integer> list0){
        return list0.get(0);
    }
}
