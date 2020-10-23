package model;

import model.enums.Priority;
import model.enums.PriorityColor;

public class PriorityTask extends Task {
    private Priority priority;
    private PriorityColor priorityColor;

    public PriorityTask() {
        this.priority = Priority.HIGH;
        this.priorityColor = PriorityColor.RED;
    }

    @Override
    public String toString() {
        return getFormattedAttributes() +
               ", priority: " + priority + ']';
    }
}
