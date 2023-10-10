package org.example;

public  class Cat implements Patricipant {
    private int maxHeight;
    private int maxLenght;
    private String name;
    public boolean superRunCount = true;

    public Cat(int maxHeight, int maxLenght, String name) {
        this.maxHeight = maxHeight;
        this.maxLenght = maxLenght;
        this.name = name;
    }

    @Override
    public boolean run(int dist) {
        if (dist <= maxLenght) {
            System.out.println(this.name + " пробежал " + dist);
            return true;
        }
        else if (superRun(superRunCount)) {
            System.out.println("Кот " + name +" пробежал " + dist + " с суперсилой");
            superRunCount=false;

            return true;
        }
        else System.out.println("Кот "+this.name + " не смог пробежать " + dist + " и выбывает");
        return false;
    }
    @Override
    public boolean jump(int height) {
        if (height <= maxHeight) {
            System.out.println("Кот "+this.name+ " перепрыгнул " + height  );
            return true;
        }
        else {
            System.out.println("Кот "+this.name+ " не смог перепрыгнуть " + height  +" и выбывает");
            return false;
        }
    }
}
