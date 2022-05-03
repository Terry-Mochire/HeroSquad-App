package models;

import java.util.ArrayList;

public class Squad {
    private String squadName;

    private static ArrayList<Squad> instances = new ArrayList<>();

    private int id;

    public Squad(String squadName){
        this.squadName = squadName;
        instances.add(this);
        this.id = instances.size();
    }


    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public int getId() {
        return id;
    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }
}
