package org.example.animals;

public class Dog extends Animals{
    private static int count;
    private static int maxRun = 500;

    public Dog(String name, int maxSwim, int age) {
        super(name, maxRun, maxSwim, age);
        count++;
    }
    public static int getCount(){
        return count;
    }

}
