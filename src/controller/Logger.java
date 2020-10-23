package controller;

import model.Task;
import model.TaskList;
import model.enums.Event;
import controller.observer.Observer;

import java.util.Set;

public class Logger extends AbstractController implements Observer {
    private TaskList taskList;

    public Logger(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public Set<Task> getTasks() {
        return taskList.getTasks();
    }

    @Override
    public void update(Task task, Event event) {
        // TODO: log into a file
        System.out.println("Logger: " + task + " Status: " + addSuffix(event));
    }
}
