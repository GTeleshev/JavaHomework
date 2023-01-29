package Seminar3;

import java.util.Arrays;
import java.util.Random;
import static java.lang.Math.min;

public class Problem1 {
    //    Реализовать алгоритм сортировки слиянием
    public static void main(String[] args) {
        //сгенерированный массив
        int[] Arr2 = FillArray(500, -100, 100);
        int[] Arr3 = Arrays.copyOf(Arr2, Arr2.length);
        int[] Arr4 = Arrays.copyOf(Arr2, Arr2.length);
        System.out.println(Arrays.toString(Arr2));
        //рекурсивная сортировка слиянием
        long startTime = System.nanoTime();
        MergeSort(Arr2, 0, Arr2.length - 1);
        long stopTime = System.nanoTime();
        System.out.println(Arrays.toString(Arr2));
        System.out.println((stopTime - startTime) + "ns - merge");
        //итеративная сортировка слиянием
        System.out.println(Arrays.toString(Arr3));
        long startTime1 = System.nanoTime();
        MergeSortIterative(Arr3, Arr3.length - 1);
        long stopTime1 = System.nanoTime();
        System.out.println(Arrays.toString(Arr3));
        System.out.println((stopTime1 - startTime1) + "ns - iter merge");
        //сортировка пузырьком
        System.out.println(Arrays.toString(Arr4));
        long startTime2 = System.nanoTime();
        BubbleSort(Arr4);
        long stopTime2 = System.nanoTime();
        System.out.println(Arrays.toString(Arr4));
        System.out.println((stopTime2 - startTime2) + "ns - bubble");
    }

    public static void MergeSort(int[] Array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            MergeSort(Array, left, mid);
            MergeSort(Array, mid + 1, right);
            MergeSubOrdered(Array, left, mid, right);
        }
    }

    static void MergeSortIterative(int[] arr, int n) {
        int iterSize;
        int leftBegin;
        for (iterSize = 1; iterSize <= n - 1;
             iterSize = 2 * iterSize) {
            for (leftBegin = 0; leftBegin < n - 1;
                 leftBegin += 2 * iterSize) {
                int mid = min(leftBegin + iterSize - 1, n - 1);
                int right_end = min(leftBegin
                        + 2 * iterSize - 1, n - 1);
                MergeSubOrdered(arr, leftBegin, mid, right_end);
            }
        }
    }

    public static void MergeSubOrdered(int[] Arr, int left, int mid, int right) {
        int[] Arr1 = Arrays.copyOfRange(Arr, left, mid + 1);
        int[] Arr2 = Arrays.copyOfRange(Arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < Arr1.length && j < Arr2.length) {
            if (Arr1[i] < Arr2[j]) Arr[k++] = Arr1[i++];
            else Arr[k++] = Arr2[j++];
        }
        while (i < Arr1.length) Arr[k++] = Arr1[i++];
        while (j < Arr2.length) Arr[k++] = Arr2[j++];
    }


    static int[] MergeOrdered(int[] Arr1, int[] Arr2) {
        int[] OutArray = new int[Arr1.length + Arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < Arr1.length && j < Arr2.length) {
            if (Arr1[i] < Arr2[j]) OutArray[k++] = Arr1[i++];
            else OutArray[k++] = Arr2[j++];
        }
        while (i < Arr1.length) OutArray[k++] = Arr1[i++];
        while (j < Arr2.length) OutArray[k++] = Arr2[j++];
        return OutArray;
    }

    public static int[] FillArray(int Size, int Min, int Max) {
        Random rand = new Random();
        int[] OutArray = new int[Size];
        for (int i = 0; i < Size; i++) {
            OutArray[i] = rand.nextInt(Max - Min) + Min;
        }
        return OutArray;
    }

    public static int[] BubbleSort(int[] Arr){
        int len = Arr.length;
        int tmp;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if(Arr[j] > Arr[j + 1]){
                    tmp = Arr[j+1];
                    Arr[j+1] = Arr[j];
                    Arr[j] = tmp;
                }
            }
        }
        return Arr;
    }
}