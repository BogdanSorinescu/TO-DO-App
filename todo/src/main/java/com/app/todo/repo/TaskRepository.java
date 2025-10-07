package com.app.todo.repo;

import com.app.todo.models.TaskEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntities, Long> {

    List<TaskEntities> id(Long id);
}
