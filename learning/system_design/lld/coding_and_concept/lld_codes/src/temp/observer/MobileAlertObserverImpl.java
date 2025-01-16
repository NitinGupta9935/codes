package temp.observer;

import temp.observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    private String userName;
    private StockObservable observable;

    public MobileAlertObserverImpl(String userName, StockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessage(userName, "Product is in stock Hurry up!");
    }

    private void sendMessage(String user, String message) {
        System.out.println("Mobile " + message);
    }
}
