package org.example;

@Table(title = "SNAKE_GORYNYCH1")

public class Snake_Gorynych1 {

    public enum Color {
        ORANGE, BLACK, RED,
    }

    public Snake_Gorynych1(String name, double age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Column
    private String name;

    public String getName() {
        return name;
    }

    @Column
    private double age;

   // @Column
    private String color;

}

