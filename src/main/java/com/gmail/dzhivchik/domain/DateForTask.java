package com.gmail.dzhivchik.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 01.09.2017.
 */

@Entity
@Table(name = "dates")
public class DateForTask {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private Date date;
    private Time time;

@ManyToMany(mappedBy = "dates", cascade = CascadeType.ALL)
    List<Task> tasks = new ArrayList<>();

    public DateForTask() {
    }

    public DateForTask(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addToTasks(Task task){
        tasks.add(task);
    }
}
