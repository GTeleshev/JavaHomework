package Seminar5;

import java.util.Arrays;
import java.util.Random;

public class Problem3 {
//    Реализовать алгоритм пирамидальной сортировки (HeapSort)
    public static void main(String[] args) {
        int size = 20;
        int maxVal = 100;
        int[] arr = new int[size];
//        NodeHeap(arr, maxVal);
        FillArray(arr, maxVal);
        System.out.println(Arrays.toString(arr));
//        ArrayHeap(arr, arr.length);
//        System.out.println(Arrays.toString(arr));
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
        }
    public static void HeapSort(int arr[]){
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--)
            NodeHeap(arr, len, i);
        for (int i = len - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            NodeHeap(arr, i, 0);
        }
    }
    public static void ArrayHeap(int arr[], int maxIndex){
        int start = (maxIndex / 2) - 1;
        for (int i = start; i >= 0; i--) {
            NodeHeap(arr, maxIndex, i);
        }
    }

    public static void NodeHeap(int[] arr,int maxNodeIndex,int i) {
        int nodeIndex = i;
        int left = 2 * nodeIndex + 1;
        int right = 2 * nodeIndex + 2;
        if (left < maxNodeIndex && arr[left] > arr[nodeIndex])
            nodeIndex = left;
//            System.out.println("left " + left + " left arr" + arr[left]);
        if (right < maxNodeIndex && arr[right] > arr[nodeIndex])
            nodeIndex = right;
//            System.out.println("right " + right + " right arr" + arr[right]);
        if (nodeIndex != i) {
            int tmp = arr[i];
            arr[i] = arr[nodeIndex];
            arr[nodeIndex] = tmp;
//            System.out.println(nodeIndex + " " + arr[nodeIndex]);
            NodeHeap(arr, maxNodeIndex, nodeIndex);
        }
    }

    public static void FillArray(int[] arr, int maxVal){
        Random rand = new Random();
        int s = arr.length;
        for (int i = 0; i < s; i++) {
            arr[i] = rand.nextInt(maxVal);
        }
    }
}