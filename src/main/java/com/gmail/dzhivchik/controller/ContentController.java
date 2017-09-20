package com.gmail.dzhivchik.controller;

import com.gmail.dzhivchik.domain.DateForTask;
import com.gmail.dzhivchik.domain.DayForTask;
import com.gmail.dzhivchik.domain.Task;
import com.gmail.dzhivchik.domain.User;
import com.gmail.dzhivchik.service.ContentService;
import com.gmail.dzhivchik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;

/**
 * Created by User on 21.08.2017.
 */

@Controller
@RequestMapping("/")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createNewTask", method = RequestMethod.POST)
    public String createNewTask(Model model,
                                @RequestParam("description") String description,
                                @RequestParam("content") String content,
                                @RequestParam("priority") String priority,
                                @RequestParam("type_of_task") String type_of_task,
                                @RequestParam(value = "task_dates", required = false) String task_dates,
                                @RequestParam(value = "day_of_week", required = false) String[] day_of_week){
        if(!description.trim().isEmpty()) {
            String login = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getUser(login);
            Task task = new Task(description, content, false, 1, 1, user);

            if(type_of_task.equals("dated")){
                String[] tempDates = task_dates.split(",");
                for (String str:tempDates) {
                    try {
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                        java.sql.Date sqlDate = new java.sql.Date(sdf1.parse(str).getTime());
                        DateForTask dateForTask = new DateForTask(sqlDate, null);
                        task.addToDatesList(dateForTask);
                    }catch (ParseException e){
                        System.out.println("Проблемы при распарсивании строки в дату.");
                    }
                }
            }

            if(type_of_task.equals("periodic")){
                for (String day:day_of_week) {
                    DayForTask dayForTask = new DayForTask(DayOfWeek.of(Integer.valueOf(day)), null);
                    task.addToDayList(dayForTask);
                }
            }
            contentService.addTask(task);
        }
        return "redirect:/";
    }
}
