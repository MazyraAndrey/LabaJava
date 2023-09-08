package org.example.animals;

public class Dog extends Animals{
    private static int count;
    private static int maxRun = 500;

    public Dog(String name, int maxSwim, int age, String type) {
        super(name, maxRun, maxSwim, age, type);
        count++;
    }
    public static int getCount(){
        return count;
    }

}
