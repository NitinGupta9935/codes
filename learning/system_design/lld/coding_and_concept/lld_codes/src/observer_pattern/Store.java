package observer_pattern;

import observer_pattern.observable.IphoneObservableImpl;
import observer_pattern.observable.StocksObservable;
import observer_pattern.observer.EmailAlertOberverImpl;
import observer_pattern.observer.MobileAlertObserverImpl;
import observer_pattern.observer.NotificationAlertObserver;

public class Store {

    public static void main(String args[]) {

        StocksObservable iphoneStockObervable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertOberverImpl("xyz1@gmail.com", iphoneStockObervable);
        NotificationAlertObserver observer2 = new EmailAlertOberverImpl("xyz2@gmail.com", iphoneStockObervable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz_username", iphoneStockObervable);

        iphoneStockObervable.add(observer1);
        iphoneStockObervable.add(observer2);
        iphoneStockObervable.add(observer3);

        iphoneStockObervable.setStockCount(10);
    }
}
