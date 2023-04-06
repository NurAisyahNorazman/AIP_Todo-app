package com.todoapp.springboottodoapp.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/todos")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //Create new task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    //Read all task
    @GetMapping
    public List<Task> readTask() {
        return taskService.readTask();
    }

    //Read all task by id
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) { return taskService.findByTaskId(id);
    }

    //Update task by id
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updateTask) {
        return taskService.updateTask(id,updateTask);
    }

    //Soft Delete by ID - Change isDeleted to true
    @DeleteMapping("/{id}")
    public Task softDelete(@PathVariable Long id) {
        return taskService.softDelete(id);
    }

    //Restore task by id
    @PutMapping("/deleted/{id}")
    public Task restoreSoftDelete(@PathVariable Long id) {
        return taskService.restoreTask(id);
    }

    //Complete Delete by ID
    @DeleteMapping("/deleted/{id}")
    public String completeDelete(@PathVariable Long id) {
        taskService.completeDelete(id);
        return "Deleted Successfully";
    }

}
