package Seminar5;

import java.util.Random;

public class Problem4 {
//    *На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
    public static int[][] board = new int[8][8];
    public static void main(String[] args) {
        int[][] vector = {{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7}};
        FillByVector(board, vector);
        Paint2DArray(board, "x ", ". ");
//        System.out.println(IsBoardSafe(vector));
//        System.out.println(vector[0][1]);
//        System.out.println(vector[7][1]);
    }
    public static boolean IsBoardSafe(int[][] vector){
        int len = vector.length;
        for (int i = 0; i < len - 1; i++) {
            if (vector[i][1] == vector[i+1][1]) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }
    public static void FillByVector(int[][] arrToFill, int[][]vector){
        int vectorLen = vector.length;
        int rows = arrToFill.length;
        if(vectorLen != rows) return;
        for (int i = 0; i < vectorLen; i++) {
            arrToFill[vector[i][0]][vector[i][1]]=1;
        }
    }
    public static void ResetBoard(int[][] arr){
        int rows = arr.length;
        int columns = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = 0;
            }
        }
    }
    public static void FillRandomly(int[][] arr){
        int rows = arr.length;
        int columns = arr[0].length;
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = rand.nextInt(2);
            }
        }
    }
    public static void Print2DArray(int[][] arr){
        int rows = arr.length;
        int columns = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void Paint2DArray(int[][] arr, String yes, String no){
        int rows = arr.length;
        int columns = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(arr[i][j] == 1) System.out.print(yes);
                else System.out.print(no);
            }
            System.out.println();
        }
    }
}
