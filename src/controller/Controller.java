package controller;

import model.Task;

import java.util.Set;

public interface Controller {
    Set<Task> getTasks();
}
