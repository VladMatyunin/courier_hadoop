package ru.kpfu.itis.model;

/**
 * Created by vladislav on 19.05.17.
 */
public class City {
    private String name;
    private int weight;

    public City(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
}
