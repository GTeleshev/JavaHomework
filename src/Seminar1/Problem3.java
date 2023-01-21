package Seminar1;

import java.util.Scanner;

public class Problem3 {
    //    Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - / *). int a ; int b;
    //    String op (op!=”Stop”); (char != ’b’)
    public static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] Args) {
        System.out.println("Калькулятор");
        Double FirstNumber;
        Double SecondNumber;
        String Oper;
        while (true) {
            FirstNumber = InputNumber("Введите первое число: ");
            SecondNumber = InputNumber("Введите второе число: ");
            Oper = InputOp("Введите операцию (+-*/, stop - выйти): ");
            System.out.println(FirstNumber + Oper + SecondNumber + "=" + Math(FirstNumber, SecondNumber, Oper));
        }
    }

    public static Double InputNumber(String Query) {
        System.out.print(Query);
        while (true) {
            if (iScanner.hasNextDouble()) return iScanner.nextDouble();
            else {
                System.out.print(Query);
                iScanner.next();
            }
        }
    }

    public static String InputOp(String Query) {
        while (true) {
            System.out.print(Query);
            switch (iScanner.next()) {
                case "+":
                    return "+";
                case "-":
                    return "-";
                case "*":
                    return "*";
                case "/":
                    return "/";
                case "stop":
                    iScanner.close();
                    System.exit(0);
            }
        }
    }

    public static Double Math(Double FNumber, Double SNumber, String Oper) {
        switch (Oper) {
            case "+":
                return Double.valueOf(FNumber + SNumber);
            case "-":
                return Double.valueOf(FNumber - SNumber);
            case "*":
                return Double.valueOf(FNumber * SNumber);
            case "/":
                return Double.valueOf(FNumber / SNumber);
        }
        return (double) 0;
    }
}