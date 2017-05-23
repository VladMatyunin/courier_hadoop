package ru.kpfu.itis.generator;

import ru.kpfu.itis.model.City;
import ru.kpfu.itis.model.CityList;
import ru.kpfu.itis.model.Route;

import java.util.Random;

/**
 * Created by vladislav on 19.05.17.
 */
public class RouteGenerator {
    private RandomDateGenerator dateGenerator;
    private Random random;
    private WeightedProbMap<City> cityGenerator;
    public RouteGenerator(){
        dateGenerator = new RandomDateGenerator();
        random = new Random();
        cityGenerator = new WeightedProbMap<City>(CityList.getPairs());
    }
    public Route createRandomRoute(){
        return new Route(getRandomCity(),getRandomCity(),dateGenerator.getRandomDate());
    }
    private City getRandomCity(){
        return cityGenerator.nextElt();
    }
}
