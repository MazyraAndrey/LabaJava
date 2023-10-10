package org.example;

public class Main {

    public static void main(String[] args) {
        Patricipant[] patricipants = {
                new Human(2, 350, "Andr"),
                new Human(3, 250, "Dimu"),
                new Cat(2, 200, "Suimmon"),
                new Cat(1, 100, "Tigger"),
                new Robot(3,400,"Cyber"),
                new Robot(7, 900, "I-2077"),
        };
        Challenge[] challenges = {
                new RunningRoad(RoadLenght.LOW),
                new RunningRoad(RoadLenght.HIGH),
                new Wall(WallHeight.LOW),
                new RunningRoad(RoadLenght.MEDIUM),
                new Wall(WallHeight.MEDIUM),
                new RunningRoad(RoadLenght.HIGH),
                new Wall(WallHeight.HIGH),
        };

        for(Patricipant p: patricipants) {
            for (Challenge c: challenges) {
                if (!c.isCan(p))
                    break;
            }
        }
    }
}