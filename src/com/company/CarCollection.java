package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sivakr on 2/10/15.
 */
public class CarCollection {

    int limit;
    List<Car> collection = new ArrayList<Car>();

    public CarCollection(int limit) {
        this.limit = limit;
    }

    public boolean isSpaceAvailable() {
        return (collection.size() < limit);
    }

    public boolean notEmpty() {
        return (collection.size() > 0);
    }

    public boolean add(Car c) {
        if (isSpaceAvailable()) {
            collection.add(c);
            return true;
        }

        return false;
    }

    public boolean remove(Car car) {
        for (Car c : collection) {
            if (c.number == car.number) {
                collection.remove(car);
                return true;
            }
        }

        return false;
    }

    public int getThreshold(){
        return (int)((float)collection.size() / limit * 100);
    }


}
