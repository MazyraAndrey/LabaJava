package org.example;
import org.example.animals.*;

public class Main {
    public static void main(String[] args) {

        Animals[] animals = {
                new Cat("Murzik", 200, 0, "Cat"),
                new Cat("Barsic", 210, 0, "Cat"),
                new Dog("Bobik", 10, 5,"Dog"),
                new Tiger("Sher_Khan", 500, 250, 20,"Tiger"),
                new Snake_Gorynych("Snake", 500, 200, 20,"Snake"),
                new The_Hunchback_Horse("Horse", 750, 500, 20,"Horse"),
                new Golden_Antelope("Antelope", 600, 150, 15,"Antelope"),
        };
        System.out.println("Количество котов: " + Cat.getCount());
        System.out.println("Количество собак: " + Dog.getCount());
        System.out.println("Количество тигров: " + Tiger.getCount());
        System.out.println("Общее количество животных: " + Animals.getCount());

        System.out.println("\nВид соревнования: бег");
        for (Animals i : animals) {
            i.run(200);
        }

        System.out.println("\nВид соревнования: плавание");
        for (Animals i : animals) {
            i.swim(300);
        }

        System.out.println("\nКоличество котов " +Cat.getCount());
        System.out.println("Количество собак " + Dog.getCount());
        System.out.println("Количество тигров " + Tiger.getCount()+"\n");

        ((Fabulous) animals[4]).power();
        ((Fabulous) animals[5]).power();
        ((Fabulous) animals[6]).power();

        System.out.println("\nОбщее количество животных " + Animals.getCount());
        System.out.println("Количество сказочных животных  " + Fabulous.getFabCount());
    }
}


