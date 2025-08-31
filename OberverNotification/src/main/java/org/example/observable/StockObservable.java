package org.example.observable;

import org.example.observer.NotificationObserver;

public interface StockObservable {
    void add(NotificationObserver notificationObserver);
    void remove(NotificationObserver notificationObserver);
    void notifySubscriber();
    void countCalculation(int count);
}
