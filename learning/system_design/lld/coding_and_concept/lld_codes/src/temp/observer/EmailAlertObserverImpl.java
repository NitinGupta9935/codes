package temp.observer;

import temp.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    private String emailId;
    private StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessage(emailId, "Product is availabe Hurry up!");
    }

    private void sendMessage(String emailId, String message) {
        System.out.println("Email " + message);
    }
}
