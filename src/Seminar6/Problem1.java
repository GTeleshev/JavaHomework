package Seminar6;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {
//    Создать множество ноутбуков.
//1. Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет выборку: имя ноутбука и выбранный критерий . Критерии фильтрации можно хранить в Map.
//    Сделать выборку.
//    Например: //    Введите цифру, соответствующую необходимому критерию: //            1 - ОЗУ
//2 - Объем ЖД //3 - Операционная система //4 - Цвет …
//    Пользователь ввел 1. Вывести в виде.
//    2. Отфильтровать ноутбуки первоначального множества. По имени ноутбука в алфавитном порядке, по цене по убыванию
//    Например, по алфавиту
    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        TreeMap<Integer, Notebook> notebooks = GetNotebookList();
        while (true){
        PrintCriteria(menu(), notebooks);
        }
    }

    public static void PriceSort(TreeMap<Integer, Notebook> notebooks){
        Map<Notebook, Integer> priceSort = new TreeMap<Notebook, Integer>(new PriceCompare());
        for (var el:notebooks.entrySet()) {
            priceSort.put(el.getValue(), el.getValue().price);
        }
        System.out.println("Название | Производитель | Процессор | RAM | HDD | OS | Цвет | Цена");
        for (var el: priceSort.entrySet()) {
            System.out.println(el.getKey().toString());
        }
    }

    public static void NameSort(TreeMap<Integer, Notebook> notebooks){
        Map<Notebook, String> nameSort = new TreeMap<Notebook, String>(new NameCompare());
        for (var el: notebooks.entrySet()) {
            nameSort.put(el.getValue(), el.getValue().name);
        }
        System.out.println("Название | Производитель | Процессор | RAM | HDD | OS | Цвет | Цена");
        for (var el: nameSort.entrySet()) {
            System.out.println(el.getKey().toString());
        }
    }

    public static void PrintCriteria(int selection, TreeMap<Integer, Notebook> notebooks){

        switch (selection) {
            case 1:
                System.out.println("Название | Процессор");
                for (var el: notebooks.entrySet()) System.out.println(el.getValue().name + " | " + el.getValue().processor);
                break;
            case 2:
                System.out.println("Название | RAM");
                for (var el: notebooks.entrySet()) System.out.println(el.getValue().name + " | " + el.getValue().RAMGB);
                break;
            case 3:
                System.out.println("Название | HDD");
                for (var el: notebooks.entrySet()) System.out.println(el.getValue().name + " | "  + el.getValue().HDDGB);
                break;
            case 4:
                System.out.println("Название | OS");
                for (var el: notebooks.entrySet()) System.out.println(el.getValue().name + " | " + el.getValue().operatingSystem);
                break;
            case 5:
                System.out.println("Название | Цвет");
                for (var el: notebooks.entrySet()) System.out.println(el.getValue().name + " | " + el.getValue().color);
                break;
            case 6:
                System.out.println("Название | Цена");
                for (var el: notebooks.entrySet()) System.out.println(el.getValue().name + " | " + el.getValue().price);
                break;
            case 7:
                NameSort(notebooks);
                break;
            case 8:
                PriceSort(notebooks);
                break;
            case 9:
                System.exit(0);
        }
    }
    public static int menu() {
        int selection;
        System.out.println("Критерии фильтрации");
        System.out.println("-------------------------");
        System.out.println("1 - Процессор");
        System.out.println("2 - Объём оперативной памяти");
        System.out.println("3 - Объём жесткого диска");
        System.out.println("4 - Операционная система");
        System.out.println("5 - Цвет");
        System.out.println("6 - Цена");
        System.out.println("7 - Сортировка по имени (в алфавитном порядке)");
        System.out.println("8 - Сортировка по цене (по убыванию)");
        System.out.println("9 - Выход");
        selection = InputNumber("Выберите критерий фильтрации: ");
        return selection;
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
    public static Map<String, Integer> SortHashMap(Map<String,Integer> mapToSort) {
        Map<String, Integer> sortedMap = mapToSort.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
        return sortedMap;
    }
    public static TreeMap<Integer, Notebook> GetNotebookList(){
        TreeMap<Integer, Notebook> notebooks = new TreeMap<>();
        Notebook nB1 = new Notebook("ASUS X515EA-BQ1185W", "ASUS", "Intel Core i5",
                8, 512, "Windows 11 Home", "Grey", 44_400);
        Notebook nB2 = new Notebook("HUAWEI MateBook D 15", "HUAWEI", "AMD Ryzen 5",
                16, 512, "Windows 11 Home", "Grey", 56_630);
        Notebook nB3 = new Notebook("Apple MacBook Air 13", "Apple", "Apple M2",
                8, 256, "macOS", "Grey space", 97_416);
        Notebook nB4 = new Notebook("HONOR MagicBook 15", "HONOR", "AMD Ryzen 5",
                16, 512, null, "Grey space", 43_974);
        Notebook nB5 = new Notebook("Lenovo IdeaPad 3", "Lenovo", "Intel Celeron N4020",
                8, 256, "Windows 11 Home", "Abyss blue", 30_385);
        Notebook nB6 = new Notebook("MSI GF6310SC-635XRU", "MSI", "Intel Core i7",
                8, 512, "DOS", "Black", 71_990);
        Notebook nB7 = new Notebook("Acer Extensa 15", "ACER", "AMD Ryzen 5",
                8, 512, null, "Black", 42_688);
        notebooks.put(1, nB1);
        notebooks.put(2, nB2);
        notebooks.put(3, nB3);
        notebooks.put(4, nB4);
        notebooks.put(5, nB5);
        notebooks.put(6, nB6);
        notebooks.put(7, nB7);
        return notebooks;
    }
}
