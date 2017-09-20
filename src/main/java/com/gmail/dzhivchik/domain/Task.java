package com.gmail.dzhivchik.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 16.08.2017.
 */

@JsonAutoDetect
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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name="task_date",
        joinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "date_id", referencedColumnName = "id")})
    List<DateForTask> dates = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "task_day",
        joinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "day_id", referencedColumnName = "id")})
    List<DayForTask> days = new ArrayList<>();

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


    public List<DayForTask> getDays() {
        return days;
    }

    public void setDays(List<DayForTask> days) {
        this.days = days;
    }

    public void addToDayList(DayForTask day){
        days.add(day);
    }

    @Override
    public String toString() {
        String dates = "[";
        for(DateForTask date:getDates()){
            dates = dates + date.getDate() + ",";
        }
        if(getDates().size() > 0){
            dates = dates.substring(0,dates.length() - 2);
        }
        dates += "]";
        return "Task{" +
                "description:'" + description + '\'' +
                ", content:'" + content + '\'' +
                ", priority:" + priority +
                ", done:" + done +
                ", repeatability:" + repeatability +
                ", dates:" + dates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (getId() != task.getId()) return false;
        if (getPriority() != task.getPriority()) return false;
        if (isDone() != task.isDone()) return false;
        if (getRepeatability() != task.getRepeatability()) return false;
        if (getDescription() != null ? !getDescription().equals(task.getDescription()) : task.getDescription() != null)
            return false;
        if (getContent() != null ? !getContent().equals(task.getContent()) : task.getContent() != null) return false;
        if (getUser() != null ? !getUser().equals(task.getUser()) : task.getUser() != null) return false;
        if (getDates() != null ? !getDates().equals(task.getDates()) : task.getDates() != null) return false;
        return getDays() != null ? getDays().equals(task.getDays()) : task.getDays() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + getPriority();
        result = 31 * result + (isDone() ? 1 : 0);
        result = 31 * result + getRepeatability();
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getDates() != null ? getDates().hashCode() : 0);
        result = 31 * result + (getDays() != null ? getDays().hashCode() : 0);
        return result;
    }
}
