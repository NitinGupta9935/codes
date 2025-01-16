package temp.observable;

import temp.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {
    private List<NotificationAlertObserver> list = new ArrayList<>();
    private int currSock = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        list.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        list.remove(observer);
    }

    @Override
    public void notifySubscriber() {
        for (NotificationAlertObserver observer: list)
            observer.update();
    }

    @Override
    public void setStockCount(int stock) {
        if (currSock == 0)
            notifySubscriber();

        currSock += stock;
    }

    @Override
    public int getStockCount() {
        return currSock;
    }
}
