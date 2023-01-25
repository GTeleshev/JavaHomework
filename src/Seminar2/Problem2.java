package Seminar2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Problem2 {
//    2. Реализуйте алгоритм сортировки пузырьком числового массива, результат
//    после каждой итерации запишите в лог-файл.
    public static Logger iLogger = Logger.getLogger(Problem2.class.getName());
    public static void main(String[] args) throws IOException {
        String Path = System.getProperty("user.dir");
        String FileName = "/src/Seminar2/sem2_log_problem2.txt";
        String FullPath = Path.concat(FileName);
        System.out.println(FullPath);
        FileHandler fh = new FileHandler(FullPath);
        iLogger.addHandler(fh);
        SimpleFormatter txt = new SimpleFormatter();
        fh.setFormatter(txt);
        int[] Array = new int[] {9,8,7,6,5,4,3,2,1};
        iLogger.log(Level.INFO, "Запуск программы (Семинар 2, задача 2, пузырьковая сортировка), массив: " +
                String.join(" ", Arrays.toString(Array)));
        PrintArray(BubbleSort(Array));
    }
    public static void PrintArray(int[] ArrayToPrint){
        for (var el: ArrayToPrint) System.out.print(el + " ");
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
                    iLogger.log(Level.INFO, "Проход " + i +
                            ", замена элементов " + j + " и " + (j + 1) +
                            "(" + Arr[j] + ", " + Arr[j+1] + ")");
                }
            }
        }
        return Arr;
    }
}