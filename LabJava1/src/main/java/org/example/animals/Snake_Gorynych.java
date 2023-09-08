package org.example.animals;

public class Snake_Gorynych extends Fabulous {

    public static int count;
    private static String power = "Snake_Gorynych Имеет три головы и умеет летать";
    public Snake_Gorynych(String name, int maxRun, int maxSwim, int age,String type){
        super(name, age, maxRun, maxSwim, type, power );
        count++;
    }
}