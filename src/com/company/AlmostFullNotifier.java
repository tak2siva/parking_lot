package com.company;

/**
 * Created by sivakr on 2/10/15.
 */
public class AlmostFullNotifier implements INotify {
    IAlmostFullEventListner almostFullEventListner;

    public AlmostFullNotifier(IAlmostFullEventListner almostFullEventListner) {
        this.almostFullEventListner = almostFullEventListner;
    }

    @Override
    public void Notify() {

        almostFullEventListner.NotifyAlmostFull();
    }
}
