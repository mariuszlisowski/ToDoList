package controller.observer;

import model.Task;
import model.enums.Event;

public interface Observer {
    void update(Task task, Event event);
}
