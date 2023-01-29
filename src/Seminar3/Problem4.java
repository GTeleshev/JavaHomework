package Seminar3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Problem4 {
    //    Каталог товаров книжного магазина сохранен в виде двумерного
//    списка List<ArrayList<String>> так, что на 0й позиции каждого
//    внутреннего списка содержится название жанра, а на остальных
//    позициях - названия книг. Напишите метод для заполнения данной
//    структуры.
    public static void main(String[] args) {
        List<ArrayList<String>> Books = new ArrayList<>();
        AddGenre(Books, "Ужастики");
        AddGenre(Books, "Фантастика");
        AddGenre(Books, "Романы");
        PrintGenres(Books);
        String newGenre = "Мемуары";
        System.out.println("Добавление жанра: " + newGenre);
        AddGenre(Books, newGenre);
        PrintGenres(Books);
        AddBook(Books, newGenre, "Книга 1");
        AddBook(Books, newGenre, "Книга 2");
        AddBook(Books, newGenre, "Книга 3");
        AddBook(Books, newGenre, "Книга 4");
        AddBook(Books, newGenre, "Книга 5");
        System.out.println("Печать жанра: " + newGenre);
        PrintBooksInGenre(Books, newGenre);
    }
    static public void PrintGenres(List<ArrayList<String>> lst0){
        System.out.print("| ");
        for (var item: lst0) {
            System.out.print(item.get(0) + " | ");
        }
        System.out.println();
    }

    static public void PrintBooksInGenre(List<ArrayList<String>> lst0, String Genre){
        System.out.print("| ");
        for (var item: lst0.get(GetGenrePosition(lst0, Genre))) {
            System.out.print(item + " | ");
        }
        System.out.println();;
    }
    public static void AddGenre(List<ArrayList<String>> lst0, String Genre){
        for (var item: lst0) {
            if(Objects.equals(item.get(0), Genre)) System.out.println("Жанр уже есть в справочнике");
            break;
        }
        lst0.add(new ArrayList<>());
        lst0.get(lst0.size() - 1).add(Genre);
    }
    public static void AddBook(List<ArrayList<String>> lst0, String Genre, String Book){
        int pos = GetGenrePosition(lst0, Genre);
        lst0.get(pos).add(Book);
    }
    static int GetGenrePosition(List<ArrayList<String>> lst0, String Genre){
        int pos = 0;
        for (var item: lst0) {
            if(Objects.equals(item.get(0), Genre)) pos = lst0.indexOf(item);
        }
        return pos;
    }
}
