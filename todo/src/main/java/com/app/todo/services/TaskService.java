package com.app.todo.services;

import com.app.todo.models.TaskEntities;
import com.app.todo.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntities> getAllTasks() {
        return taskRepository.findAll();
    }
}
