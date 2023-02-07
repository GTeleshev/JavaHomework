package Seminar5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Problem1 {
//    1) Реализуйте структуру телефонной книги с помощью HashMap,
//    учитывая, что 1 человек может иметь несколько телефонов.
    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, String> phoneBook = FillPhoneBook();
        System.out.println(phoneBook);
        PrintPhonebook(phoneBook);
    }
    public static Map<String, String> FillPhoneBook(){
        Map<String, String> newPhonebook = new HashMap<>();
        while (true){
            String nextLine;
            String[] nL = new String[2];
            System.out.print("Введите фамилию и телефон через пробел (распечатать - print): ");
            nextLine = iScanner.nextLine();
            if(Objects.equals(nextLine, "print")) break;
            else {
                nL[0] = nextLine.split(" ")[0];
                nL[1] = nextLine.split(" ")[1];
                newPhonebook.put(nL[1], nL[0]);
            }
        }
        return newPhonebook;
    }

    public static void PrintPhonebook(Map<String, String> phoneBook){
        System.out.println("фамилия | Телефон");
        for (var entry: phoneBook.entrySet()) {
            System.out.print(entry.getValue() + " | ");
            System.out.println(entry.getKey());
        };
    }
}