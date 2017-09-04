package com.gmail.dzhivchik.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 16.08.2017.
 */

@Entity
@Table(name = "tasks")
public class Task{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String description;
    private String content;
    private int priority;
    private boolean done;
    private int repeatability;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(
        name="task_date",
        joinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "date_id", referencedColumnName = "id")})
    List<DateForTask> dates = new ArrayList<>();

    public Task() {

    }

    public Task(String description, String content, boolean done, int repeatability, int priority, User user) {
        this.description = description;
        this.content = content;
        this.done = done;
        this.repeatability = repeatability;
        this.priority = priority;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(int repeatability) {
        this.repeatability = repeatability;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DateForTask> getDates() {
        return dates;
    }

    public void setDates(List<DateForTask> dates) {
        this.dates = dates;
    }

    public void addToDatesList(DateForTask date){
        dates.add(date);
    }
}
