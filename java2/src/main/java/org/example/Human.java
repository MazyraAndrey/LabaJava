package org.example;

public class Human implements Patricipant {
    private int maxHeight;
    private int maxLenght;
    private String name;
    public boolean superRunCount = true;

    public Human(int maxHeight, int maxLenght, String name) {
        this.maxHeight = maxHeight;
        this.maxLenght = maxLenght;
        this.name = name;
    }

    @Override
    public boolean run(int dist) {
        if (dist <= maxLenght){
            System.out.println(this.name + " пробежал " + dist + " м");
            return true;
        }
        else if (superRun(superRunCount)) {
            System.out.println("Человек " + name +" пробежал " + dist + " с суперсилой");
            superRunCount=false;
            return true;
        }
        else
            System.out.println("Человек " +this.name + " не смог пробежать " + dist + " м и выбывает");
            return false;
    }

    @Override
    public boolean jump(int height) {
        if (height<= maxHeight) {
            System.out.println("Человек "+this.name+ " перепрыгнул " + height  + " м");
            return true;
        }
        else {
            System.out.println("Человек "+this.name+ " не смог перепрыгнуть " + height  + " м и выбывает");
            return false;
        }
    }
}
