package Seminar4;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
public class Problem3 {
//    * В калькулятор добавьте возможность отменить последнюю операцию.
    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] Args) throws IOException {
        System.out.println("Калькулятор");
        int FirstNumber;
        int SecondNumber;
        String Oper;
        String expr = "";
        while (true) {
            FirstNumber = InputNumber("Введите первое число: ");
            expr += String.valueOf(FirstNumber);
            SecondNumber = InputNumber("Введите второе число: ");
            expr += String.valueOf(SecondNumber);
            Oper = InputOp("Введите операцию (+-*), stop - выйти: ");
            expr += Oper;
            System.out.println("Результат: " + PostfixEval(expr));
            Oper = InputOp("+-*/ - новая операция, stop - выйти: ");
            expr = expr.substring(0,expr.length()-1);
            expr += Oper;
            System.out.println("Результат: " + PostfixEval(expr));
            expr = "";
        }
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

    public static Double PostfixEval(String expr){
        Stack<Double> exprStack = new Stack<>();
        int len = expr.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(expr.charAt(i))){
                exprStack.push(Double.parseDouble(String.valueOf(expr.charAt(i))));}
            else{
                System.out.println(String.valueOf(expr.charAt(i)));
                switch (String.valueOf(expr.charAt(i))){
                    case "*":
                        exprStack.push(exprStack.pop() * exprStack.pop());
                        break;
                    case "/":
                        exprStack.push(1 / (exprStack.pop() / exprStack.pop()));
                        break;
                    case "+":
                        exprStack.push(exprStack.pop() + exprStack.pop());
                        break;
                    case "-":
                        exprStack.push(-exprStack.pop() + exprStack.pop());
                        break;
                }
            }
        }
        return exprStack.pop();
    }
}
