package fitnesstracker.designs.notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyUsers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}