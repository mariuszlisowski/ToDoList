package model.factory;

import model.Task;
import model.enums.Status;
import model.enums.StatusColor;

public abstract class TaskFactory {
    public Task createTask(String title) {
        Task task = createSpecificTask();
        task.setTitle(title);
        task.setStatus(Status.INCOMPLETED);
        task.setStatusColor(StatusColor.BLACK);
        task.addCurrentDateTime();

        return task;
    }

    protected abstract Task createSpecificTask();

}
