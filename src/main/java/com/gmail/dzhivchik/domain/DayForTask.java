package com.gmail.dzhivchik.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13.09.2017.
 */

@JsonAutoDetect
@Entity
@Table(name = "days")
public class DayForTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private DayOfWeek day;
    private Time time;

    @JsonIgnore
    @ManyToMany(mappedBy = "days", cascade = CascadeType.ALL)
    List<Task> tasks = new ArrayList<>();

    public DayForTask() {
    }

    public DayForTask(DayOfWeek day, Time time) {
        this.day = day;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DayForTask)) return false;

        DayForTask that = (DayForTask) o;

        if (getId() != that.getId()) return false;
        if (getDay() != that.getDay()) return false;
        if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) return false;
        return getTasks() != null ? getTasks().equals(that.getTasks()) : that.getTasks() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getDay() != null ? getDay().hashCode() : 0);
        result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
        result = 31 * result + (getTasks() != null ? getTasks().hashCode() : 0);
        return result;
    }
}
