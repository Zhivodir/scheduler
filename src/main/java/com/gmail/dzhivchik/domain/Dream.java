package com.gmail.dzhivchik.domain;

/**
 * Created by User on 16.08.2017.
 */
public class Dream {
    private long id;
    private String name;
    private String description;

    public Dream() {
    }

    public Dream(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
