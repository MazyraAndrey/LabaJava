package org.example;

public class Robot implements Patricipant {
    private int maxHeight;
    private int maxLenght;
    private String name;
    public boolean superRunCount = true;

    public Robot(int maxHeight, int maxLenght, String name) {
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
            System.out.println("Робот " + name +" пробежал " + dist + " с суперсилой");
            superRunCount=false;
            return true;
        }
        else
            System.out.println("Робот "+this.name + " не смог пробежать " + dist + " м и выбывает");
            return false;
    }
    @Override
    public boolean jump(int height) {
        if (height<= maxHeight) {
            System.out.println("Робот "+this.name+ " перепрыгнул " + height  +" м");
            return true;
        }
        else {
            System.out.println("Робот "+this.name+ " не смог перепрыгнуть " + height  +" м и выбывает");
            return false;
        }
    }
}
