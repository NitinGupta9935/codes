package temp;

import temp.observable.*;
import temp.observer.*;

public class Store {

    public static void main(String args[]) {
        StockObservable observable = new IphoneObservableImpl();

        NotificationAlertObserver notificationAlertObserver1 = new EmailAlertObserverImpl("Email@1", observable);
        NotificationAlertObserver notificationAlertObserver2 = new EmailAlertObserverImpl("Email@2", observable);
        NotificationAlertObserver mobileAlerObserver = new MobileAlertObserverImpl("User@1", observable);

        observable.add(notificationAlertObserver1);
        observable.add(notificationAlertObserver2);
        observable.add(mobileAlerObserver);

        observable.setStockCount(23);

    }
}
