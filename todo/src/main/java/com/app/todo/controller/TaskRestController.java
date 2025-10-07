package com.app.todo.controller;
import com.app.todo.models.TaskEntities;
import com.app.todo.services.TaskService;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

public class TaskRestController {

    private final TaskService taskService;


    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskEntities> getTasks(){
        return taskService.getAllTasks();
    }
}
