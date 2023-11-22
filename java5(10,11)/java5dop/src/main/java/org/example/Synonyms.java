package org.example;

import java.util.*;

public class Synonyms {
    private LinkedHashMap<String, LinkedHashSet<String>> synonyms = new LinkedHashMap<>();

    public void add(String term, String synonym) {
        LinkedHashSet<String> wordsForTerm = this.synonyms.getOrDefault(term, new LinkedHashSet<>());


        for (String key : this.synonyms.keySet()) {
            if (!key.equals(term) && this.synonyms.get(key).contains(synonym)) {
                System.out.println("Синоним '" + synonym + "' уже используется для термина '" + key + "' и '" + term + "'.");
                return;
            }
        }

        if (!wordsForTerm.contains(synonym)) {
            wordsForTerm.add(synonym);
            this.synonyms.put(term, wordsForTerm);
        } else {
            System.out.println("У термина '" + term + "' уже есть синоним '" + synonym + "'.");
        }
    }
    public void printAll() {
        for (String key : this.synonyms.keySet()) {
            LinkedHashSet<String> synonymsForTerm = this.synonyms.get(key);
            System.out.println(key + " синонимы: " + String.join(", ", synonymsForTerm));
        }
    }
}
