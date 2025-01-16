package observer_pattern.observer;

import observer_pattern.observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String userName;
    StocksObservable observable;

    public MobileAlertObserverImpl(String userName, StocksObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessage(userName, "Product is in stock hurry up!");
    }

    private void sendMessage(String userName, String msg) {
        System.out.println("msg sent to:" + userName);
        // send the actual mail to the end user
    }
}
