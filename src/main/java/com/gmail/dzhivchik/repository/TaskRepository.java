package com.gmail.dzhivchik.repository;

import com.gmail.dzhivchik.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by User on 21.08.2017.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT task from Task task where task.user.id = :id")
    List<Task> findByUser(@Param("id") int id);
}
