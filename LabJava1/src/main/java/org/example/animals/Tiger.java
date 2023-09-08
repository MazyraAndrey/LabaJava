package org.example.animals;

public class Tiger extends Animals {
    private static int count;
    public Tiger(String name,  int maxRun, int maxSwim, int age,String type) {
        super(name, maxRun, maxSwim, age,type);
        count++;
    }
    public static int getCount(){
        return count;
    }
}

