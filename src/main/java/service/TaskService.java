package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;

public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // 1. Create a Task
    public void createTask(Task task) {
        taskRepository.save(task);
    }


}
