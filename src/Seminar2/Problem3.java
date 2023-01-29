package Seminar2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.*;

public class Problem3 {
//    3. ** Дана json строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//    {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//    {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//    Написать метод(ы), который распарсит json и, используя StringBuilder,
//    создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//    Пример вывода:
//    Студент Иванов получил 5 по предмету Математика.
//    Студент Петрова получил 4 по предмету Информатика.
//    Студент Краснов получил 5 по предмету Физика.
    public static void main(String[] args) {
        String Path = System.getProperty("user.dir");
        String FileName = "/src/Seminar2/Prob3.json";
        String FullPath = Path.concat(FileName);
        String JsonString = ReturnJSONString(FullPath);
        String[] Columns = {"фамилия", "оценка","предмет"};
        String[][] arr1 = JSONto2DArr(JsonString,Columns);
        String[] Headers = {"Студент ", " получил ", " по предмету "};
        Print2DArrayHeaders(arr1, Headers, ".\n");

    }
    public static String[][] JSONto2DArr(String Str, String[] Columns){
        String newStr = Str.replace("\"","").
                replace("[{","").replace("}]","").
                replace("{","").replace(":","");
        String[] Arr = newStr.split("},");
        ArrayList<String[]> outerArr = new ArrayList<String[]>();
        for (int j = 0; j < Arr.length; j++) {
            for (int i = 0; i < Columns.length; i++){
                Arr[j] = Arr[j].replace(Columns[i], "");
            }
            outerArr.add(Arr[j].split(","));
        }
        int Rows = Arr.length;
        int Cols = Columns.length;
        String[][] strArr = new String[Rows][Cols];
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                strArr[i][j] = outerArr.get(i)[j];
            }
        }
        return strArr;
    }
    public static String ReturnJSONString(String FileName){
        StringBuilder JSONString = new StringBuilder();
        FileReader JSONObj = null;
        try {
            JSONObj = new FileReader(FileName);
            Scanner iScanner = new Scanner(JSONObj);
            while(iScanner.hasNextLine()) JSONString.append(iScanner.nextLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            JSONString.append("[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                    "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                    "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");
        } finally {
            try {
                if (JSONObj != null) {
                    JSONObj.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return JSONString.toString();
    }
    public static void Print2DArray(String[][] inpArray){
        for (int i = 0; i < inpArray.length; i++) {
            for (int j = 0; j < inpArray[i].length; j++) {
                System.out.print(inpArray[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void Print2DArrayHeaders(String[][] inpArray, String[] Headers, String suffix){
        for (int i = 0; i < inpArray.length; i++) {
            for (int j = 0; j < inpArray[i].length; j++) {
                System.out.print(Headers [j] + inpArray[i][j]);
            }
            System.out.print(suffix);
        }
    }
}
