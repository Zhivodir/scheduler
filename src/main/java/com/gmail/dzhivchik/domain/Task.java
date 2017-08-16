package com.gmail.dzhivchik.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 16.08.2017.
 */
public class Task extends Purpose {
    private int priority;
    private String periodichnost;

    public Task() {
        super();
    }

    public Task(String name, String description, Date timeLimits, List<Task> pointsForImplementation, int priority, String periodichnost) {
        super(name, description, timeLimits, pointsForImplementation);
        this.priority = priority;
        this.periodichnost = periodichnost;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getPeriodichnost() {
        return periodichnost;
    }

    public void setPeriodichnost(String periodichnost) {
        this.periodichnost = periodichnost;
    }
}
