package com.gmail.dzhivchik.service.Impl;

import com.gmail.dzhivchik.domain.Task;
import com.gmail.dzhivchik.domain.User;
import com.gmail.dzhivchik.repository.TaskRepository;
import com.gmail.dzhivchik.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 21.08.2017.
 */

@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public boolean addTask(Task task) {
        if(taskRepository.save(task) != null){
            return true;
        }
        return false;
    }

    @Override
    public List<Task> getTasks(User user) {
        return taskRepository.findByUser(user.getId());
    }
}
