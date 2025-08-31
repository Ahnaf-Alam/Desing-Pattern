package org.example.observer;

import org.example.observable.StockObservable;

public class EmailNotification implements NotificationObserver {
    private StockObservable stockObservable;
    private String email;

    public EmailNotification(StockObservable so, String email) {
        this.stockObservable = so;
        this.email = email;
    }

    @Override
    public void update() {
        sendEmail(email);
    }

    private void sendEmail(String email) {
        System.out.println("email send to " + email);
    }
}
