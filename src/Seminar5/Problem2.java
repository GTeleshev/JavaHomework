package Seminar5;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {
//    2) Пусть дан список сотрудников:Иван Иванов и т.д.
//     Написать программу, которая найдет и выведет повторяющиеся имена
//     с количеством повторений. Отсортировать по убыванию популярности.
    public static void main(String[] args) {
        String employees = "Афанасий Петров,Иван Иванов,Иван Петров,Сергей Сидоров," +
                "Алексей Петров,Иван Сидоров,Иван Сыроежкин,Алексей Сидоров";
        Map<String, Integer> newMap = StringToHashmap(employees);
        System.out.println(newMap);
        SortHashMap(newMap);
        Map<String,Integer> sortedMap = SortHashMap(newMap);
        System.out.println(sortedMap);
    }
    public static Map<String, Integer> SortHashMap(Map<String,Integer> mapToSort){
        Map<String, Integer> sortedMap = mapToSort.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new));
        return sortedMap;
    }
    public static Map<String, Integer> StringToHashmap(String employees){
        String[] empl = employees.split(",");
        String[][] emplSplit = new String[2][empl.length];
        for (int i = 0; i < empl.length; i++) {
            emplSplit[0][i] = empl[i].split(" ")[0];
            emplSplit[1][i] = empl[i].split(" ")[1];
        }
        Map<String, Integer> newMap = new HashMap<>();
        for (int i = 0; i < emplSplit[0].length; i++) {
            if((newMap.isEmpty() == false) && (newMap.containsKey(emplSplit[0][i]) == true)){
                int tmp = newMap.get(emplSplit[0][i]);
                newMap.put(emplSplit[0][i], tmp + 1);
            }
            else newMap.put(emplSplit[0][i], 1);
        }
        return newMap;
    }

}
