package model;

import controller.observer.Observable;
import controller.observer.Observer;
import model.enums.Event;
import model.enums.Priority;
import model.enums.Status;
import model.enums.StatusColor;
import model.factory.PriorityTaskFactory;
import model.factory.RegularTaskFactory;
import model.factory.TaskFactory;

import java.util.HashSet;
import java.util.Set;

public class TaskList implements Observable {
    private final Set<Observer> observers = new HashSet<>();
    private String listName;
    private Set<Task> tasks;

    public TaskList(String listName) {
        this.listName = listName;
        this.tasks = new HashSet<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Task task, Event event) {
        for (Observer observer : observers) {
            observer.update(task, event);
        }
    }

    public void removeList() {
        tasks.clear();
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void addTask(String title, Priority priority) {
        TaskFactory taskFactory = null;

        if (priority == Priority.HIGH) {
            taskFactory = new PriorityTaskFactory();
        } else if (priority == Priority.LOW) {
            taskFactory = new RegularTaskFactory();
        } else {
            throw new IllegalArgumentException("Unknown priority: " + priority);
        }

        Task taskToAdd = taskFactory.createTask(title);
        notifyObservers(taskToAdd, Event.ADD);
        tasks.add(taskToAdd);
    }

    public void removeTask(String title) {
        Task taskToRemove = findTaskByTitle(title);

        notifyObservers(taskToRemove, Event.REMOVE);
        tasks.remove(taskToRemove);
    }

    public void markCompleted(String title) {
        Task taskToComplete = findTaskByTitle(title);

        taskToComplete.setStatus(Status.COMPLETED);
        taskToComplete.setStatusColor(StatusColor.GRAY);

        notifyObservers(taskToComplete, Event.COMPLETE);
        tasks.add(taskToComplete);
    }

    public void markIncompleted(String title) {
        Task taskToIncomplete = findTaskByTitle(title);

        taskToIncomplete.setStatus(Status.INCOMPLETED);
        taskToIncomplete.setStatusColor(StatusColor.BLACK);

        notifyObservers(taskToIncomplete, Event.INCOMPLETE);
        tasks.add(taskToIncomplete);
    }

    private Task findTaskByTitle(String title) {
        Task matchingTask = null;
        for (Task task : tasks) {
            if (title != null && title.equals(task.getTitle())) {
                matchingTask = task;
                break;
            }
        }
        if (matchingTask != null) {
            return matchingTask;
        } else {
            throw new NullPointerException("No such task!");
        }
    }
}
