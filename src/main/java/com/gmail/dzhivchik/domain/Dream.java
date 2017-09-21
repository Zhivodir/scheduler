package com.gmail.dzhivchik.domain;

import javax.persistence.*;

/**
 * Created by User on 16.08.2017.
 */

@Entity
@Table(name = "dreams")
public class Dream {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String description;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Dream() {
    }

    public Dream(String description, String content, User user) {
        this.description = description;
        this.content = content;
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Dream{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
