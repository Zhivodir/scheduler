package com.gmail.dzhivchik.controller;

import com.gmail.dzhivchik.domain.User;
import com.gmail.dzhivchik.domain.enums.UserRoleEnum;
import com.gmail.dzhivchik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by User on 10.08.2017.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "/create_new_user", method = RequestMethod.POST)
    public String createNewUser(Model model,
                                @RequestParam("login") String login,
                                @RequestParam("password") String password,
                                @RequestParam("email") String email){
        if(!login.trim().isEmpty() && !password.trim().isEmpty() && !email.trim().isEmpty()) {
            User user = new User(login, email, password, UserRoleEnum.USER);
            if(userService.addUser(user)) {
                return "redirect:/login";
            }
        }
        return "registration";
    }
}
