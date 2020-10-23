package controller;

import model.Task;
import model.TaskList;
import model.enums.Event;
import controller.observer.Observer;

import java.util.Set;

public class Programmer extends AbstractController implements Observer {
    private final String userName;
    private TaskList taskList;

    public Programmer(String userName, TaskList taskList) {
        this.userName = userName;
        this.taskList = taskList;
    }

    @Override
    public Set<Task> getTasks() {
        return taskList.getTasks();
    }

    @Override
    public void update(Task task, Event event) {
        // TODO: send notification to a server
        System.out.println(userName + ": " + task + " Status: " + addSuffix(event));
    }
}
