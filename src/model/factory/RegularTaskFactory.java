package model.factory;

import model.RegularTask;
import model.Task;

public class RegularTaskFactory extends TaskFactory {
    @Override
    protected Task createSpecificTask() {
        return new RegularTask();
    }

}
