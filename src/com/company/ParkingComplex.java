package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sivakr on 2/10/15.
 */
public class ParkingComplex {

    private List<Attende> attendes = new ArrayList<Attende>();

    public ParkingComplex() {
        InitAttendes();
    }

    private void InitAttendes(){
        Attende attende1 = new Attende(2);
        Attende attende2 = new Attende(3);

        attendes.add(attende1);
        attendes.add(attende2);
    }


}
