package org.example.animals;

public class Quagga extends Extinct {

    public static int count;

    public Quagga(String name, int maxRun, int maxSwim, int age,String die){
        super(name, age, maxRun, maxSwim, die);
        count++;
    }
}
