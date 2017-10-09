package com.gmail.dzhivchik.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.dzhivchik.domain.Purpose;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

/**
 * Created by User on 08.09.2017.
 */

@Controller
@RequestMapping("/")
public class AjaxController {
    @Autowired
    private ContentService contentService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/ajax/load_task_for_selected_date", method = RequestMethod.POST)
    public String loadTaskForSelectedDate(Model model,
                                          @RequestParam(value = "data", required = false) String data){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUser(login);
        //Сегодняшняя дата
        String result = "";
        if(data != null) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                java.sql.Date dateForSearch = new java.sql.Date(sdf.parse(data).getTime());
                java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
                cal.setTime(dateForSearch);
                List<Task> tasks = contentService.getTasks(user, dateForSearch, DayOfWeek.of(cal.get(cal.DAY_OF_WEEK)));
                StringWriter writer = new StringWriter();
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(writer, tasks);
                result = writer.toString();
            } catch (ParseException e) {
                System.out.println("Проблемы при распарсивании строки в дату.");
            } catch (IOException e) {
                System.out.println("");
            }
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/ajax/load_tree_of_purposes_and_tasks", method = RequestMethod.GET)
    public String loadTreeOfPorposesAndTasks(Model model,
                                             @RequestParam(value = "id", required = false) String id){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUser(login);
        List<Purpose> content = null;
        if(id == "") {
            content = contentService.getPurposes(user);
        }
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, content);
        } catch (IOException e){e.printStackTrace();}
        String result = writer.toString();
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/ajax/load_embedded_tasks", method = RequestMethod.POST)
    public String loadEmbeddedTasks(Model model,
                                    @RequestParam(value = "id", required = false) String id){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUser(login);
        List<Task> taskForPurpose = contentService.getTasks(user, Long.valueOf(id));
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, taskForPurpose);
        } catch (IOException e){e.printStackTrace();}
        String result = writer.toString();
        System.out.println(result);
        return result;
    }
}
