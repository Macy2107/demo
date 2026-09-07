package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.TaskService;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    // Define the CRUD operators
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    @ResponseBody
    public String home(){
        return ">:33!";
    }

    @GetMapping("/api/{status}")
    public Map<String, String> status(@PathVariable String status) {
        return Map.of("status", "running");
    }

    // 1. Create a Task POST /api/tasks
    @PostMapping("/tasks")
    public String createTask(@RequestBody model.Task task) {
         taskService.createTask(task);
         return "Task created successfully";
    }

    // 2. Get All Tasks
    @GetMapping("/tasks")
    public List<model.Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // 3. Get Task by ID
    @GetMapping("/tasks/{id}")
    public model.Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // 4. Update a Task
    @PutMapping("/tasks/{id}")
    public model.Task updateTask(@PathVariable Long id, @RequestBody model.Task task) {
        taskService.updateTask(id, task);
        return taskService.getTaskById(id);
    }

    // 5. Delete a Task
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }

    // 6. Get Tasks by Status
    @GetMapping("/status/{status}")
    public String getTaskByStatus(@PathVariable String status) {
        taskService.getTaskByStatus(status);
        return "Fetching tasks with status: " + status;
    }
}

