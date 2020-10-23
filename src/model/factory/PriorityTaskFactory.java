package model.factory;

import model.PriorityTask;
import model.Task;

public class PriorityTaskFactory extends TaskFactory {
    @Override
    protected Task createSpecificTask() {
        return new PriorityTask();
    }
}
