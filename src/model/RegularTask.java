package model;

import model.enums.Priority;
import model.enums.PriorityColor;

public class RegularTask extends Task {
    private Priority priority;
    private PriorityColor priorityColor;

    public RegularTask() {
        this.priority = Priority.LOW;
        this.priorityColor = PriorityColor.YELLOW;
    }

    @Override
    public String toString() {
        return getFormattedAttributes() +
                ", priority: " + priority + ']';
    }
}
