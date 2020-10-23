package model;

import model.enums.Status;
import model.enums.StatusColor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    private String title;
    private LocalDateTime dateTime;
    private Status status;
    private StatusColor statusColor;

    public void setTitle(String title) {
        this.title = title;
    }
    public void setStatus(Status status) { this.status = status; }
    public void setStatusColor(StatusColor statusColor) {
        this.statusColor = statusColor;
    }

    public String getTitle() { return title; }

    public void addCurrentDateTime() {
        dateTime = LocalDateTime.now();
    };

    protected String getFormattedAttributes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy hh:mm a");

        return "Task [" +
                "title: '" + title + '\'' +
                ", date & time: " + dateTime.format(formatter) +
                ", status: " + status;
    }
}
