package org.example.animals;

public class Cat extends Animals {
    private static int count;
    private static int maxSwim = 0;
    public Cat(String name, int maxRun, int age, String type) {
        super(name, maxRun, maxSwim, age, type);
        count++;
    }
    public static int getCount(){
        return count;
    }
}
