package org.example.animals;

public class Extinct extends Animals {

    private String die;

    public static int count;

    public Extinct(String name, int maxRun, int maxSwim, int age, String die) {
        super(name, age, maxRun, maxSwim);
        this.die = die;
        count++;
    }

    public void dieout() {
        System.out.println(getClass().getSimpleName()+" "+ getName() + " "+die);
    }

    public static int getFabCount() {
        return count;
    }
}