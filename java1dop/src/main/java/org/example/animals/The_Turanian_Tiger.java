package org.example.animals;

public class The_Turanian_Tiger extends Extinct {

    public static int count;
    public The_Turanian_Tiger(String name, int maxRun, int maxSwim, int age,String die){
        super(name, age, maxRun, maxSwim,die);
        count++;
    }
}