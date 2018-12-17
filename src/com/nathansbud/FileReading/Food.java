package com.nathansbud.FileReading;

public class Food {
    private String name, desc;
    private float cost;

    Food(String _name, String _desc, float _cost) {
        name = _name;
        desc = _desc;
        cost = _cost;
    }

    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    public float getCost() {
        return cost;
    }
}
