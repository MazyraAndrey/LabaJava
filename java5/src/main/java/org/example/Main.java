package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"ct", "java", "add", "ping", "gg", "help", "ct", "help", "loss", "fps"};
        HashMap<String, Integer> wordList = new HashMap<>();
        for (String a : words) {
            wordList.put(a, wordList.getOrDefault(a, 0) + 1);
        }
        System.out.println(wordList.entrySet() + "\n");

        Translator translator  = new Translator();

        translator.add("jam","джем");
        translator.add("jam","варенье");
        translator.add("jam","варенье");

        translator.add("book","книга");
        translator.add("book","журнал");


        translator.add("bandage","повязка");
        translator.add("bandage","бинт");

        translator.printAll();
    }
}