package com.gmail.dzhivchik.service;

import com.gmail.dzhivchik.domain.Task;
import com.gmail.dzhivchik.domain.User;

import java.util.List;

/**
 * Created by User on 21.08.2017.
 */
public interface ContentService {
    boolean addTask(Task task);
    List<Task> getTasks(User user);
}