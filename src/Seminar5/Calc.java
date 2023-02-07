package Seminar5;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Calc {
//    * В калькулятор добавьте возможность отменить последнюю операцию.
    public static Scanner iScanner = new Scanner(System.in);
    public static Stack<Double> resultStack = new Stack<>();
    public static void main(String[] Args) throws IOException {
        System.out.println("Калькулятор");
        double FirstNumber;
        double SecondNumber;
        String Oper;
        int count = 0;
        while (true) {
            FirstNumber = InputNumber("Введите первое число: ", "Введите первое число " +
                    "(back - использовать предыдущий результат): ", count);
            count += 1;
            SecondNumber = InputNumber("Введите второе число: ",
                    "Введите второе число: ", count);
            Oper = InputOp("Введите операцию (+-*/), stop - выйти: ");
            Double result = Math(FirstNumber, SecondNumber, Oper);
            resultStack.push(result);
            System.out.println("Результат: " + result);
        }
    }

    public static double InputNumber(String Query, String secondQuery, int count) {
        if(count == 0) System.out.print(Query);
        else System.out.print(secondQuery);
        while (true) {
            if (iScanner.hasNextDouble()) return iScanner.nextDouble();
            else if (Objects.equals(iScanner.next(), "back")) {
                return resultStack.pop();
            } else {
                System.out.print(Query);
                iScanner.next();
            }
        }
    }

    public static String InputOp(String Query) {
        while (true) {
            System.out.print(Query);
            switch (iScanner.next()) {
                case "+": return "+";
                case "-": return "-";
                case "*": return "*";
                case "/": return "/";
                case "stop": System.exit(0);
            }
        }
    }
    public static Double Math(Double FNumber, Double SNumber, String Oper) {
        return switch (Oper) {
            case "+" -> FNumber + SNumber;
            case "-" -> FNumber - SNumber;
            case "*" -> FNumber * SNumber;
            case "/" -> FNumber / SNumber;
            default -> (double) (0.0);
        };
    }
}