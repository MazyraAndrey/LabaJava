package org.example;
import org.example.animals.*;

public class Main {
    public static void main(String[] args) {

        Animals[] animals = {
                new Cat("Murzik", 200, 1),
                new Cat("Barsic", 210, 1),
                new Dog("Bobik", 10, 5),
                new Tiger("Sher_Khan", 500, 250, 20),
                new The_Turanian_Tiger("Шархан", 500, 200, 20, "вымер в первой половине XX века, примерно в 1930-х годах."),
                new Quagga("Дима", 750, 500, 20, "подвид зебры, вымер в середине XIX века, примерно в 1883 году."),
                new Tarpan("Егор", 600, 150, 15, "вымер в XVIII веке, примерно в 1800 году."),

        };
        new Tarpan("Егор", 600, 150, 15, "вымер в XVIII веке, примерно в 1800 году.");

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

       ((Extinct) animals[4]).dieout();
       ((Extinct) animals[5]).dieout();
       ((Extinct) animals[6]).dieout();

        System.out.println("\nОбщее количество животных " + Animals.getCount());
        System.out.println("Количество вымерших животных  " + Extinct.getFabCount());
    }
}


