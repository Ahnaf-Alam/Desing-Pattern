package org.example;

import org.example.observable.IphoeStockObservable;
import org.example.observable.StockObservable;
import org.example.observer.EmailNotification;
import org.example.observer.NotificationObserver;

public class Main {
    public static void main(String[] args) {
        StockObservable stockObservable = new IphoeStockObservable();

        NotificationObserver observer = new EmailNotification(stockObservable, "testqwe@ymail.com");
        NotificationObserver observer1 = new EmailNotification(stockObservable, "test123@ymail.com");

        stockObservable.add(observer);
        stockObservable.add(observer1);

        stockObservable.countCalculation(12);
        stockObservable.countCalculation(0);
    }
}