package com.company;

/**
 * Created by sivakr on 2/10/15.
 */
public class SlotFullNotifier implements INotify {
    ISlotFullListner slotFullListner;

    public SlotFullNotifier(ISlotFullListner slotFullListner) {
        this.slotFullListner = slotFullListner;
    }

    @Override
    public void Notify() {
        slotFullListner.NotifySlotFull();
    }
}
