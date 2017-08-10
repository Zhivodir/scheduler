package com.gmail.dzhivchik.service;

import com.gmail.dzhivchik.domain.User;


public interface UserService {
    User getUser(String login);
    void addUser(User user);
}