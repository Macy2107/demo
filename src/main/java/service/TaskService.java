package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // 1. Create a Task
    public void createTask(model.Task task) {
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
    public model.Task updateTask(Long id, model.Task updatedTask) {
        return taskRepository.findById(id).map(task -> { // Using Lambda statement to fetch the updatedTask
            task.setTitle(updatedTask.getTitle());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        }).orElse(null);
    }

    // 5. Delete Task
    public boolean deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }

    // 6. Get Tasks by Status
    public List<model.Task> getTaskByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

}
