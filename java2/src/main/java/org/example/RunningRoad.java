package org.example;

public class RunningRoad implements Challenge{

    String name;

    public RunningRoad(RoadLenght roadLenght) {
        this.name=roadLenght.getTitle();
        this.roadLength = roadLenght.getLenght();
    }
    int roadLength;
    @Override
    public boolean isCan(Patricipant patricipant) {
        if(patricipant.run(roadLength)) return true;
        else return false;
    }
}

