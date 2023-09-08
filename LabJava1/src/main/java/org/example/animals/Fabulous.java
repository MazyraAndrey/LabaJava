package org.example.animals;

public class Fabulous extends Animals{
   public String power;

    public static int count;
    public Fabulous(String name, int maxRun, int maxSwim, int age,String type, String power){
        super(name, age, maxRun, maxSwim, type);
        this.power=power;
        count++;
    }

    public static int getFabCount(){
        return count;
    }

    public void power() {
            System.out.println(power);
    }
}
