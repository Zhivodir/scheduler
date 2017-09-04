package com.gmail.dzhivchik.domain;

import com.gmail.dzhivchik.domain.enums.UserRoleEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 09.08.2017.
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

//    private List<Dream> dreams = new ArrayList<>();
//    private List<Purpose> purposes = new ArrayList<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public User() {
    }

    public User(String login, String email, String password, UserRoleEnum role) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
