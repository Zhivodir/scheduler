package com.gmail.dzhivchik.repository;

import com.gmail.dzhivchik.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.DayOfWeek;
import java.util.List;

/**
 * Created by User on 21.08.2017.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t from Task t INNER JOIN t.dates d where t.user.id = :id and d.date = :date")
    List<Task> findByUserAndDate(@Param("id") int id, @Param("date") Date date);

    @Query("SELECT t from Task t INNER JOIN t.days d where t.user.id = :id and d.day = :day")
    List<Task> findByUsetAndDay(@Param("id") int id, @Param("day") DayOfWeek day);

    @Query("SELECT t from Task t INNER JOIN t.purposes p where t.user.id = :id and p.id = :purpose_id")
    List<Task> findByPurpose(@Param("id") int id, @Param("purpose_id") long purpose_id);
}
