package org.example;

import java.util.*;

public class Translator {
    private LinkedHashMap<String, LinkedHashSet<String>> translator = new LinkedHashMap<>();

    public void add(String term, String translation) {
        LinkedHashSet<String> words = translator.getOrDefault(term, new LinkedHashSet<>());

        if (!words.contains(translation)) {
            words.add(translation);
            translator.put(term, words);
        } else {
            System.out.println("Термин '" + term + "' уже имеет перевод '" + translation + "'.");
        }
    }

    public void printAll() {

        for (String key : translator.keySet()) {
            LinkedHashSet<String> translations = translator.get(key);
            System.out.println(key + " перевод: " + String.join(", ", translations));
        }
    }
}
