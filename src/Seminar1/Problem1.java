package Seminar1;

public class Problem1 {
    //    Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    public static int Number = 6;

    public static void main(String[] args) {
        System.out.println("Число: " + Number);
        System.out.println("Треугольное число(формула): " + TNumberFormula(Number));
        System.out.println("Треугольное число(цикл): " + TNumberCycle(Number));
        System.out.println("Треугольное число(рекурсия): " + TNumberRec(Number));
        System.out.println("Факториал(рекурсия): " + Fact(Number));
    }

    public static long TNumberFormula(int num) {
        int triangularNum;
        triangularNum = (num * (num + 1)) / 2;
        return triangularNum;
    }

    public static long TNumberCycle(int num) {
        int triangularNum = 0;
        for (int i = 0; i <= num; i++) {
            triangularNum += i;
        }
        return triangularNum;
    }

    public static long TNumberRec(int num) {
        if (num < 1) return 0;
        else return TNumberRec(num - 1) + num;
    }

    public static long Fact(int num) {
        if (num <= 1) return 1;
        else return Fact(num - 1) * num;
    }
}