package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sivakr on 2/10/15.
 */
public class ParkingLot {

    //List<Car> parkingSpace = new ArrayList<Car>();
    CarCollection carCollection;
    private int price;
    //HashMap<Integer, Car> parkingSpace = new HashMap<int, Car>();


    public ParkingLot(int limit, int price) {
        this.price = this.price;
        carCollection = new CarCollection(limit);
    }

    public boolean park(Car carToAdd) {
        boolean carAdded = carCollection.add(carToAdd);

        notifyStatus();
        return carAdded;
    }

    public boolean unPark(Car carToRemove) {
        boolean isFullBefore = !carCollection.isSpaceAvailable();
        boolean carRemoved = carCollection.remove(carToRemove);

        notifyStatus();
        return carRemoved;
    }

    public boolean isParkingSpaceAvailable() {
        return carCollection.isSpaceAvailable();
    }

    Map<NotificationTypes,List<INotify>> listners = new HashMap<NotificationTypes, List<INotify>>();

    public void RegisterForNotifications(NotificationTypes type, INotify listner) {
        if(listners.containsKey(type)) {
            listners.get(type).add(listner);
        }
        else {
            List<INotify> lis = new ArrayList<INotify>();
            lis.add(listner);
            listners.put(type, lis);
        }
    }

    public void SendNotification(NotificationTypes type) {
        if(listners.get(type) == null)
            return;
        for (INotify listner : listners.get(type)) {
            listner.Notify();
        }
    }

    private void notifyStatus()
    {
        int threshold = carCollection.getThreshold();
        if(threshold < 80)
        {
            SendNotification(NotificationTypes.available); // green
        }
        else if(threshold < 100)
        {
            SendNotification(NotificationTypes.almostFull); //orange
        }
        else
        {
            SendNotification(NotificationTypes.full); //red
        }
    }
}
