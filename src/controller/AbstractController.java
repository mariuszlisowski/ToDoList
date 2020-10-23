package controller;

import model.enums.Event;

public abstract class AbstractController implements Controller {
    protected String addSuffix(Event event) {
        return switch (event) {
            case ADD -> "added";
            case REMOVE -> "removed";
            case COMPLETE -> "done";
            case INCOMPLETE -> "to do";
        };
    }
}
