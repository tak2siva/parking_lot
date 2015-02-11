package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sivakr on 2/10/15.
 */
public class Attende {
    List<ParkingLot> parkingLots;

    public Attende(int n) {
        for (int i = 0; i < n; i++) {
            parkingLots.add(new ParkingLot(10, 5));
        }
    }
}
