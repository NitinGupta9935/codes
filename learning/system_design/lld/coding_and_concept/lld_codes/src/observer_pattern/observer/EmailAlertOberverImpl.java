package observer_pattern.observer;

import observer_pattern.observable.StocksObservable;

public class EmailAlertOberverImpl implements NotificationAlertObserver{
    String emailId;
    StocksObservable observable;

    public EmailAlertOberverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMail(emailId, "Product is in stock hurry up!");
    }

    private void sendMail(String emailId, String msg) {
        System.out.println("mail sent to:" + emailId);
        // sent the actual email to the end user
    }
}
