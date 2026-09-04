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

    // 2. Get All Tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // 3. Get Task by ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).
                orElse(null);
    }
}
