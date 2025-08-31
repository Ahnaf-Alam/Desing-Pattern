package org.example.observable;

import org.example.observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoeStockObservable implements StockObservable {
    public int stockCount = 0;

    public List<NotificationObserver> observerList = new ArrayList<>();

    @Override
    public void add(NotificationObserver notificationObserver) {
        observerList.add(notificationObserver);
    }

    @Override
    public void remove(NotificationObserver notificationObserver) {
        observerList.remove(notificationObserver);
    }

    @Override
    public void notifySubscriber() {
        for(NotificationObserver observer: observerList) {
            observer.update();
        }
    }

    @Override
    public void countCalculation(int count) {
        if(this.stockCount == 0) {
            notifySubscriber();
        }
        this.stockCount = this.stockCount + count;
    }

    public int getStockCount() {
        return stockCount;
    }

    public List<NotificationObserver> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<NotificationObserver> observerList) {
        this.observerList = observerList;
    }
}
