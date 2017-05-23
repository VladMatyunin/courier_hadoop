package ru.kpfu.itis.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladislav on 19.05.17.
 */
public class CityList {
    public static final City[] cities = new City[]{
            new City("Москва",30),
            new City("Казань", 15),
            new City("Екатеринбург", 10),
            new City("Омск", 10),
            new City("Нижний Новгород", 15),
            new City("Челябинск", 10),
            new City("Архангельск", 8),
            new City("Астрахань", 10),
            new City("Краснодар", 10),
            new City("Иркутск", 6),
            new City("Севастополь", 8),
            new City("Волгоград", 10),
            new City("Липецк", 8),
    };
    public static List<Pair<Integer,City>> getPairs(){
        ArrayList<Pair<Integer,City>> pairs = new ArrayList<Pair<Integer, City>>();
        for (City c:CityList.cities){
            pairs.add(new Pair<Integer, City>(c.getWeight(),c));
        }
        return pairs;
    }
}
