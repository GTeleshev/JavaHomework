package Seminar2;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;
public class Problem4 {
//    4. К калькулятору из предыдущего дз добавить логирование.
    public static Scanner iScanner = new Scanner(System.in);
    public static Logger iLogger = Logger.getLogger(Problem4.class.getName());
    public static void main(String[] Args) throws IOException {
        String Path = System.getProperty("user.dir");
        String FileName = "/src/Seminar2/sem2_log_problem4.txt";
        String FullPath = Path.concat(FileName);
        FileHandler fh = new FileHandler(FullPath);
        iLogger.addHandler(fh);
        SimpleFormatter txt = new SimpleFormatter();
        fh.setFormatter(txt);
        iLogger.log(Level.INFO, "Запуск программы (Семинар 2, задача 4, калькулятор с логированием)");
        System.out.println("Калькулятор");
        Double FirstNumber;
        Double SecondNumber;
        String Oper;
        while (true) {
            FirstNumber = InputNumber("Введите первое число: ");
            iLogger.log(Level.INFO, "Первое число: " + FirstNumber.toString());
            SecondNumber = InputNumber("Введите второе число: ");
            iLogger.log(Level.INFO, "Второе число: " + SecondNumber.toString());
            Oper = InputOp("Введите операцию (+-*/, stop - выйти): ");
            iLogger.log(Level.INFO, "Операция: " + Oper.toString());
            Double res = Math(FirstNumber, SecondNumber, Oper);
            System.out.println(FirstNumber + Oper + SecondNumber + "=" + res);
            iLogger.log(Level.INFO, "Результат: " + res.toString());
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
                case "+": return "+";
                case "-": return "-";
                case "*": return "*";
                case "/": return "/";
                case "stop":
                    iScanner.close();
                    iLogger.log(Level.INFO, "stop");
                    System.exit(0);
            }
        }
    }

    public static Double Math(Double FNumber, Double SNumber, String Oper) {
        switch (Oper) {
            case "+": return Double.valueOf(FNumber + SNumber);
            case "-": return Double.valueOf(FNumber - SNumber);
            case "*": return Double.valueOf(FNumber * SNumber);
            case "/": return Double.valueOf(FNumber / SNumber);
        }
        return (double) (0.0);
    }
}
