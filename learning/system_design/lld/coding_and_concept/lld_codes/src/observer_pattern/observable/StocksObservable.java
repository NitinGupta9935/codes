package observer_pattern.observable;

import observer_pattern.observer.NotificationAlertObserver;

public interface StocksObservable {

    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySubscriber();

    public void setStockCount(int newStockAdded);

    public int getStockCount();

}
