package com.app.todo.services;

import com.app.todo.models.TaskEntities;
import com.app.todo.repo.TaskRepository;
import org.springframework.scheduling.config.Task;
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

    public TaskEntities createTask(TaskEntities task){
        return taskRepository.save(task);
    }

    public TaskEntities updateTask(Long id, TaskEntities taskDetails){
        TaskEntities task = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found with id: " + id));
        task.setTitle(taskDetails.getTitle());
        task.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(task);

    }

    public TaskEntities getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found with id: " + id));
    }
}
