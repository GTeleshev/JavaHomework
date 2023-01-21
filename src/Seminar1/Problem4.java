package Seminar1;

import java.util.Scanner;

public class Problem4 {
    //    *+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
    //    например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
    //    Предложить хотя бы одно решение или сообщить, что его нет. 24 45 //24 + 45 = 69 (n=2)
    public static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] Args) {
        int FirstNumber = InputNumber("Введите первое число: ");
        int FirstMask = InputMask("Введите маску первого числа (*?), " +
                "? - цифра которую можно заменить: ");
        int SecondNumber = InputNumber("Введите второе число: ");
        int SecondMask = InputMask("Введите маску второго числа (*?), " +
                "? - цифра которую можно заменить: ");
        int ThirdNumber = InputNumber("Введите третье число: ");
        System.out.println("Число: ");
        System.out.println(RotateNumber(FirstNumber, FirstMask, SecondNumber, SecondMask, ThirdNumber));
    }

    public static int InputNumber(String Query) {
        System.out.print(Query);
        while (true) {
            if (iScanner.hasNextInt()) return iScanner.nextInt();
            else {
                System.out.print(Query);
                iScanner.next();
            }
        }
    }

    public static int InputMask(String Query) {
        System.out.print(Query);
        String mask = iScanner.next();
        return mask.indexOf("?");
    }

    public static int RotateNumber(int FNumber, int FMask, int SNumber, int SMask, int TNumber) {
        int RNumber = -1;
        int[] FArray = NumToArray(FNumber);
        int[] SArray = NumToArray(SNumber);
        for (int i = 0; i < 10; i++) {
            FArray[FMask] = i;
            SArray[SMask] = i;
            FNumber = ArrayToNum(FArray);
            SNumber = ArrayToNum(SArray);
            if (IsSum(FNumber, SNumber, TNumber)) RNumber = i;
        }
        return RNumber;
    }

    public static boolean IsSum(int FNum, int SNum, int TNum) {
        return (FNum + SNum) == TNum;
    }

    public static int[] NumToArray(int Num) {
        int Len = String.valueOf(Num).length();
        int[] arr = new int[Len];
        for (int i = Len - 1; i >= 0; i--) {
            arr[i] = Num % 10;
            Num = (Num / 10);
        }
        return arr;
    }

    public static int ArrayToNum(int[] NumArray) {
        int Len = NumArray.length;
        int Num = 0;
        for (int i = 0; i <= (Len - 1); i++) {
            Num += (int) (NumArray[i] * Math.pow(10, (Len - i - 1)));
        }
        return Num;
    }

    public static void PrintArray(int[] Arr) {
        for (var el : Arr) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}