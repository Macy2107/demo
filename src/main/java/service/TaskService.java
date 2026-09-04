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
    public List<model.Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // 3. Get Task by ID
    public model.Task getTaskById(Long id) {
        return taskRepository.findById(id).
                orElse(null);
    }

    // 4. Update Task
    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setStatus(updatedTask.getStatus());
            return taskRepositoru.save(task);
        }).orElses(null);
    }

    // 5. Delete Task
    public boolean deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            return false;
        }
        taskRepository.deleteById(id);
        return "Task is deleted successfully";
    }

    // 6. Get Tasks by Status
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}
