package org.example;


public class Main {
    public static void main(String[] args) throws Exception {
        Snake_Gorynych[] snakeGorynyches = {
                new Snake_Gorynych("Тифон", 178, "ORANGE"),
                new Snake_Gorynych("Пифон", 201, "RED"),
                new Snake_Gorynych("Цет", 157, "BLACK")
        };
       Requests.createTable(Snake_Gorynych.class);

       for(Snake_Gorynych k:snakeGorynyches){
           Requests.insertIntoTable(k);
       }

        Snake_Gorynych1 snake_gorynych1 = new Snake_Gorynych1("Тифон1", 17.584, "ORANGE");
        Requests.createTable(Snake_Gorynych1.class);
        Requests.insertIntoTable(snake_gorynych1);
    }
}