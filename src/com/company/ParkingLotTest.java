package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ParkingLotTest {

    @Test
    public void shouldAddCarToParkingLot() {
        ParkingLot parkingLot = new ParkingLot(10, 0);
        Car c1 = new Car(2001);

        assertEquals(true, parkingLot.park(c1));
    }

    @Test
    public void shouldUnparkCarFromParkingLot() {
        ParkingLot parkingLot = new ParkingLot(10, 0);
        Car c1 = new Car(2001);

        parkingLot.park(c1);

        assertEquals(true, parkingLot.unPark(c1));
    }

    @Test
    public void shouldNotUnparkCarFromParkingLot() {
        ParkingLot parkingLot = new ParkingLot(10, 0);
        Car c1 = new Car(2001);

        assertEquals(false, parkingLot.unPark(c1));
    }

    @Test
    public void shouldNotAllocateCarBeyondLimit() {
        ParkingLot parkingLot = new ParkingLot(2, 0);
        Car c1 = new Car(200);
        Car c2 = new Car(201);
        Car c3 = new Car(203);

        parkingLot.park(c1);
        parkingLot.park(c2);

        assertEquals(false, parkingLot.park(c3));
    }

    @Test
    public void shouldIndicateHouseFull() {
        ParkingLot parkingLot = new ParkingLot(1, 0);
        Car c1 = new Car(200);

        parkingLot.park(c1);

        assertEquals(false, parkingLot.isParkingSpaceAvailable());
    }

    @Test
    public void shouldNotifyAllListners() {
        ParkingLot parkingLot = new ParkingLot(1, 0);

        INotify someListener = mock(INotify.class);

        parkingLot.RegisterForNotifications(NotificationTypes.full, someListener);

        parkingLot.park(new Car(123));

        verify(someListener, times(1)).Notify();
    }


    @Test
    public void checkThresholdReached()
    {
        ParkingLot parkingLot = new ParkingLot(2, 0);
        Car c = new Car(200);
        parkingLot.park(c);

        assertEquals(50, parkingLot.carCollection.getThreshold());
    }

    @Test
    public void shouldNotifyAvailableEvent(){
        ParkingLot parkingLot = new ParkingLot(4, 0);
        Owner owner = new Owner();
        INotify slotFullNotifier = mock(INotify.class);
        Car c1 = new Car(100);
        Car c2 = new Car(100);

        parkingLot.RegisterForNotifications(NotificationTypes.available, slotFullNotifier);

        parkingLot.park(c1);
        parkingLot.park(c2);

        verify(slotFullNotifier ,times(2)).Notify();

    }

    @Test
    public void shouldNotifyAlmostFullEvent(){
        ParkingLot parkingLot = new ParkingLot(5, 0);
        Owner owner = new Owner();
        INotify almostFullNotifier = mock(INotify.class);
        Car c1 = new Car(100);
        Car c2 = new Car(100);
        Car c3 = new Car(100);
        Car c4 = new Car(100);

        parkingLot.RegisterForNotifications(NotificationTypes.almostFull, almostFullNotifier);

        parkingLot.park(c1);
        parkingLot.park(c2);
        parkingLot.park(c3);
        parkingLot.park(c4);

        verify(almostFullNotifier ,times(1)).Notify();

    }

    @Test
    public void shouldNotifyFullEvent(){
        ParkingLot parkingLot = new ParkingLot(1, 0);
        Owner owner = new Owner();
        INotify slotFullListener = mock(SlotFullNotifier.class);
        //INotify fullNotifier = mock(INotify.class);
        Car c1 = new Car(100);

        parkingLot.RegisterForNotifications(NotificationTypes.full, slotFullListener);

        parkingLot.park(c1);

        verify(slotFullListener,times(1)).Notify();

    }
}