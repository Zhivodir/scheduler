package com.gmail.dzhivchik.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by User on 16.08.2017.
 */

@Entity
@Table(name = "dreams")
public class Dream {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private String content;

    public Dream() {
    }

    public Dream(String description, String content) {
        this.description = description;
        this.content = content;
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
}
