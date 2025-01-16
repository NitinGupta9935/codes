package temp.observable;

import temp.observer.*;

public interface StockObservable {

    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySubscriber();

    public void setStockCount(int stock);

    public int getStockCount();

}
