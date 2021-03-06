package com.gmail.dzhivchik.service;

import com.gmail.dzhivchik.domain.Dream;
import com.gmail.dzhivchik.domain.Purpose;
import com.gmail.dzhivchik.domain.Task;
import com.gmail.dzhivchik.domain.User;

import java.sql.Date;
import java.time.DayOfWeek;
import java.util.List;

/**
 * Created by User on 21.08.2017.
 */
public interface ContentService {
    boolean addTask(Task task);
    boolean addDream(Dream dream);
    boolean addPurpose(Purpose purpose);

    List<Task> getTasks(User user, Date date, DayOfWeek dayOfWeek);
    List<Task> getTasks(User user, long purpose_id);
    List<Dream> getDreams(User user);
    List<Purpose> getPurposes(User user);
    List<Purpose> getPurposes(User user, long[] purpose_id);
}
