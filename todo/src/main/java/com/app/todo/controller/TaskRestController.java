package com.app.todo.controller;
import com.app.todo.models.TaskEntities;
import com.app.todo.services.TaskService;
import org.aspectj.lang.annotation.DeclareWarning;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskRestController {

    private final TaskService taskService;


    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskEntities> getTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskEntities createTask(@RequestBody TaskEntities task) {
        return taskService.createTask(task);
    }


    @GetMapping("/{id}")
    public TaskEntities getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskEntities updateTask(@PathVariable Long id, @RequestBody TaskEntities task){
        return taskService.updateTask(id, task);
    }


    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }





}
