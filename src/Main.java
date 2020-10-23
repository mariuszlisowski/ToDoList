import controller.Programmer;
import controller.Controller;
import controller.observer.Observer;
import model.TaskList;
import model.enums.Priority;
import controller.Logger;

public class Main {
    public static void main(String[] args) {
        TaskList tasks = new TaskList("TODO every day");

        Controller logger = new Logger(tasks);
        Controller programmer = new Programmer("Hacker", tasks);

        tasks.attach((Observer) logger);
        tasks.attach((Observer) programmer);

        tasks.addTask("wake up", Priority.HIGH);
        tasks.addTask("eat", Priority.LOW);
        tasks.addTask("do code", Priority.HIGH);
        tasks.addTask("sleep", Priority.LOW);

        try {
            tasks.removeTask("eat");
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }

        tasks.markCompleted("wake up");
        tasks.markCompleted("sleep");
        tasks.markIncompleted("sleep");

        programmer.getTasks().forEach(System.out::println);

        tasks.detach((Observer) logger);
        tasks.detach((Observer) programmer);
        tasks.removeList();
    }
}
