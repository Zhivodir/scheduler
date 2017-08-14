package com.gmail.dzhivchik.service.Impl;

import com.gmail.dzhivchik.domain.User;
import com.gmail.dzhivchik.repository.UserRepository;
import com.gmail.dzhivchik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by User on 06.02.2017.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUser(String login) {
        return userRepository.findByLogin(login);
    }


    @Override
    @Transactional
    public boolean addUser(User user) {
        if(userRepository.save(user) != null){
            return true;
        }
        return false;
    }
}
