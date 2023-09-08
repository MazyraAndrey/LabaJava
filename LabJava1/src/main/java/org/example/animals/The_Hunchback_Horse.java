package org.example.animals;

public class The_Hunchback_Horse extends Fabulous {

    public static int count;
    private static String power = "The_Hunchback_Horse Одно из его необычных волшебных свойств умение летать";
    public The_Hunchback_Horse(String name, int maxRun, int maxSwim, int age, String type){
        super(name, age, maxRun, maxSwim, type, power);
        count++;
    }
}
