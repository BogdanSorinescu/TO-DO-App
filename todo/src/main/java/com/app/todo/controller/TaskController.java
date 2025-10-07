package com.app.todo.controller;


import org.springframework.ui.Model;
import com.app.todo.models.TaskEntities;
import com.app.todo.services.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    //@RequestMapping("/tasks")
    public String getTasks(Model model){
        List<TaskEntities> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}
