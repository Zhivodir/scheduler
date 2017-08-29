package com.gmail.dzhivchik.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 16.08.2017.
 */
public class Purpose extends Dream{
    private Date timeLimits;
    private boolean done;
    private List<Task> pointsForImplementation;


    public Purpose() {
        super();
    }

    public Purpose(String name, String description, Date timeLimits, List<Task> pointsForImplementation, boolean done) {
        super(name, description);
        this.timeLimits = timeLimits;
        this.pointsForImplementation = pointsForImplementation;
        this.done = done;
    }


    public Date getTimeLimits() {
        return timeLimits;
    }

    public void setTimeLimits(Date timeLimits) {
        this.timeLimits = timeLimits;
    }

    public List<Task> getPointsForImplementation() {
        return pointsForImplementation;
    }

    public void setPointsForImplementation(List<Task> pointsForImplementation) {
        this.pointsForImplementation = pointsForImplementation;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
