import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    // Define the CRUD operators
    @Autowired
    private TaskService taskService;

    // 1. Create a Task
    @PostMapping("/task")
    public String createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return "Task created successfully";
    }

    // 2. Get All Tasks
    @GetMapping("/tasks")
    public List<model.Task> getAllTasks(@RequestBody Task task) {
        return taskService.getAllTasks();
    }

    // 3. Get Task by ID
    @GetMapping("/tasks{id}")
    public model.Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // 4. Update a Task
    @PutMapping
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
        return taskService.getTaskById(id);
    }

    // 5. Delete a Task
    @DeleteMapping("task/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully"
    }

    // 6. Get TAsks by Status
    @GetMapping("/status/{status}")
    public String getTaskByStatus(@PathVariable String status) {
        taskService.getTaskByStatus(status);
        return "Fetching tasks with status: " + status;
    }
}

// Define the CRUD operators
@PostMapping("/tasks") {
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }
}

// 1. Get all tasks
@GetMapping("/tasks")
public ResponseEntity<List<Task>> getAllTasks() {
    return ResponseEntity.ok(getAllTask());
}