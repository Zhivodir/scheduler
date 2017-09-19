package com.gmail.dzhivchik.controller;

import com.gmail.dzhivchik.domain.User;
import com.gmail.dzhivchik.service.ContentService;
import com.gmail.dzhivchik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;

/**
 * Created by User on 22.08.2017.
 */

@Controller
@RequestMapping("/")
public class ViewController {
    @Autowired
    private UserService userService;

    @Autowired
    private ContentService contentService;

    @RequestMapping(method = RequestMethod.GET)
    public String onIndex(Model model){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUser(login);
        Date date = new java.sql.Date(System.currentTimeMillis());
        java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
        cal.setTime(date);
        System.out.println("Current day:" + cal.get(cal.DAY_OF_WEEK));
        model.addAttribute("tasks", contentService.getTasks(user, date));
        return "tasks";
    }
}
