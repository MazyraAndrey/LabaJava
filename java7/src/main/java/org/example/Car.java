package org.example;

import java.util.concurrent.CyclicBarrier;

import static org.example.Stage.*;

public class Car implements Runnable {
    private static CyclicBarrier startBarrier;
    private static CyclicBarrier Barrier;
    private static int CARS_COUNT;
    private static final Car[] winners = new Car[3];

    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed , CyclicBarrier Barrier) {
        this.race = race;
        this.speed = speed;
        Car.Barrier = Barrier;
        CARS_COUNT++;
        this.name = "Участник №" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            Barrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this, i, race);
                if (i == race.getStages().size() - 1) {
                    getWin();
                }
                resultSmp.release();
            }
            Barrier.await();
            Barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private final Object monitor = new Object();
    private static int count = 1;
    public void getWin() {
        synchronized (monitor){
        int position = (int) count;
        if (position <= 3) {
            winners[position - 1] = this;
                System.out.println(name + " - занял " + position + " место.");
            }
        }
        count++;
    }
}