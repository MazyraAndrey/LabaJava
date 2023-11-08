package org.example;

import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void findWords(List<String> words) {
       {
           System.out.println(words.stream().collect(groupingBy(w -> w, counting())).entrySet().stream()
                   .filter(entry -> entry.getValue() > 1)
                   .collect(groupingBy(Map.Entry::getValue, TreeMap::new, toList()))
                   .lastEntry()
                   .getValue()
                   .stream()
                   .filter(entry -> entry.getValue() > 1 ? words.stream()
                           .collect(groupingBy(w -> w, counting()))
                           .values()
                           .stream()
                           .filter(count -> count == entry.getValue()).count() == 1 ||entry.getKey().length() <= 5 : true)
                   .map(Map.Entry::getKey)
                   .collect(joining(", ")));
        }


    }


    public static void main(String[] args) {
        System.out.println(" — Задание №1");

        List<String> words = new ArrayList<>(Arrays.asList("apple", "pear", "pear","pear","pear","orange","orange", "orange", "banan","banan", "banan","banan","kiwi", "apple", "pear", "mango", "orange", "banan", "apple"));


        findWords(words);

        System.out.println("\n — Задание №2");
        Contact[] contacts = new Contact[]{
                new Contact("Иван", "Иванов", 25, "+79009891299"),
                new Contact("Мария", "Петрова", 30, "+79501239637"),
                new Contact("Александр", "Сидор", 22, "+79121745588"),
                new Contact("Екатерина", "Козлова", 28, "+79120000000"),
                new Contact("Сергей", "Михайлов", 35, "+79123030308"),
        };
        findContacts(contacts, "912");
    }

    public static void findContacts(Contact[] contacts, String digits) {
        System.out.println(Arrays.stream(contacts)
                .filter(contact -> contact.getNumber().contains(digits))
                .limit(2)
                .sorted(Comparator.comparingInt(contact -> contact.getSurname().length()))
                .map(contact -> contact.getName())
                .collect(joining(", ", "Контакты с нужными цифрами: ", "")));
    }
}