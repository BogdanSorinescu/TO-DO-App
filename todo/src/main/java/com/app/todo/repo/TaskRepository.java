package com.app.todo.repo;

import com.app.todo.models.TaskEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntities, Long> {

    List<TaskEntities> id(Long id);

    @Modifying
    @Query("DELETE FROM TaskEntities t WHERE t.completed = true")
    void deleteByCompletedTrue();

}
