//package com.example.itlittlecrm.controller;
//
//import com.example.itlittlecrm.models.Task;
//import com.example.itlittlecrm.repo.TaskRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class RestController {
//    private final TaskRepository taskRepository;
//
//    @Autowired
//    public RestController(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }
//
//    @GetMapping("/tasks/{taskName}")
//    public Task getTaskByName(@PathVariable String taskName) {
//        return taskRepository.findByTaskName(taskName);
//    }
//
//    @GetMapping("/tasks")
//    public List<Task> getTasksByName(
//            @RequestParam(value = "name", required = false) String taskName) {
//        if (taskName != null) {
//            return taskRepository.findByTaskNameContains(taskName);
//        }
//        return (List<Task>) taskRepository.findAll();
//    }
//
//    @GetMapping("/subsystems/{subsystemId}/tasks")
//    public List<Task> getTasksBySubsystem(@PathVariable Long subsystemId) {
//        return taskRepository.findBySubsystemContains(subsystemId);
//    }
//
//    @PostMapping("/tasks")
//    public Task createTask(@RequestBody Task task) {
//        return taskRepository.save(task);
//    }
//
//    @PutMapping("/tasks/{id}")
//    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
//        task.setId(id);
//        return taskRepository.save(task);
//    }
//
//    @DeleteMapping("/tasks/{id}")
//    public void deleteTask(@PathVariable Long id) {
//        taskRepository.deleteById(id);
//    }
//}
