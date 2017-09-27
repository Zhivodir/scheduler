package com.gmail.dzhivchik.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 16.08.2017.
 */

@Entity
@Table(name = "purposes")
public class Purpose{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String content;
    private int priority;
    @Column(name = "time_limits")
    private Date timeLimits;
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "purposes", cascade = CascadeType.ALL)
//    private List<Task> pointsForImplementation;


    public Purpose() {
    }

    public Purpose(String description, String content, int priority,  Date timeLimits, boolean done, User user) {
        this.description = description;
        this.content = content;
        this.priority = priority;
        this.timeLimits = timeLimits;
        this.done = done;
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

    public Date getTimeLimits() {
        return timeLimits;
    }

    public void setTimeLimits(Date timeLimits) {
        this.timeLimits = timeLimits;
    }

//    public List<Task> getPointsForImplementation() {
//        return pointsForImplementation;
//    }
//
//    public void setPointsForImplementation(List<Task> pointsForImplementation) {
//        this.pointsForImplementation = pointsForImplementation;
//    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
