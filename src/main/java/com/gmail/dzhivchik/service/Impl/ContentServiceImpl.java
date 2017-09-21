package com.gmail.dzhivchik.service.Impl;

import com.gmail.dzhivchik.domain.Dream;
import com.gmail.dzhivchik.domain.Task;
import com.gmail.dzhivchik.domain.User;
import com.gmail.dzhivchik.repository.DreamRepository;
import com.gmail.dzhivchik.repository.TaskRepository;
import com.gmail.dzhivchik.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 21.08.2017.
 */

@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private DreamRepository dreamRepository;

    @Override
    @Transactional
    public boolean addTask(Task task) {
        if(taskRepository.save(task) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean addDream(Dream dream) {
        if(dreamRepository.save(dream) != null){
            return true;
        }
        return false;
    }

    @Override
    public List<Task> getTasks(User user, Date date, DayOfWeek dayOfWeek) {
        Set<Task> temp = new HashSet<>();
        temp.addAll(taskRepository.findByUserAndDate(user.getId(), date));
        temp.addAll(taskRepository.findByUsetAndDay(user.getId(), dayOfWeek));
        List<Task> result = new ArrayList<>();
        result.addAll(temp);
        return result;
    }

    @Override
    public List<Dream> getDreams(User user) {
        return dreamRepository.findByLogin(user.getLogin());
    }
}
