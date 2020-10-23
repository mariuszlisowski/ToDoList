package controller.observer;

import model.Task;
import model.enums.Event;

public interface Observable {
    void notifyObservers(Task task, Event event);
    void attach(Observer observer);
    void detach(Observer observer);
}
