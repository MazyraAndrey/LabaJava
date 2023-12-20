package org.example;

@Table(title = "SNAKE_GORYNYCH")
public class Snake_Gorynych {

    public enum Color
    {
        ORANGE, BLACK, RED,
    }
    public Snake_Gorynych(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    @Column
    private String name;
    public String getName(){
        return name;
    }
    @Column
    private int age;
    @Column
    private String color;

}
