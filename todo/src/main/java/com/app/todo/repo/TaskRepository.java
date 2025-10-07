package com.app.todo.repo;

import com.app.todo.models.TaskEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntities, Long> {

}
