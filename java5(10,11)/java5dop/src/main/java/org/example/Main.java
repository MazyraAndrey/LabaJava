package org.example;

import java.util.*;

public class  Main {
    public static void main(String[] args) {
        String[] words = {"компьютер", "программирование", "добавить", "пинг", "хорошо", "помощь", "компьютер", "помощь", "потеря", "кадры"};
        HashMap<String, Integer> wordList = new HashMap<>();
        for (String a : words) {
            wordList.put(a, wordList.getOrDefault(a, 0) + 1);
        }
        System.out.println(wordList.entrySet() + "\n");

        Synonyms Synonyms  = new Synonyms();

        Synonyms.add("компьютер", "кодинг");
        Synonyms.add("компьютер", "пк");

        Synonyms.add("компьютер", "комп");
        Synonyms.add("компьютер", "пк");

        Synonyms.add("программирование", "кодинг");
        Synonyms.add("программирование", "кодирование");

        Synonyms.add("помощь", "поддержка");
        Synonyms.add("помощь", "содействие");

        Synonyms.printAll();
    }
}