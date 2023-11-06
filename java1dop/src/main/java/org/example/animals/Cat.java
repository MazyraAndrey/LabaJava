package org.example.animals;

public class Cat extends Animals {
    private static int count;
    private static int maxSwim = 0;
    public Cat(String name, int maxRun, int age) {
        super(name, maxRun, maxSwim, age);
        count++;
    }
    public static int getCount(){
        return count;
    }
}
