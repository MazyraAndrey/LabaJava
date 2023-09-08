package org.example.animals;

public class Golden_Antelope extends Fabulous {

    public static int count;
    private static String power = "Golden_Antelope При ударе копыт о поверхность земли антилопа высекает золотые монеты";
    public Golden_Antelope(String name, int maxRun, int maxSwim, int age, String type){
        super(name, age, maxRun, maxSwim, type, power);
        count++;
    }
}
