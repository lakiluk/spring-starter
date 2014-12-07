package org.dworski.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Task {

    @NotNull
    private int id;
    @NotEmpty(message = "{task.title.required}")
    private String title;
    @NotEmpty(message = "{task.priority.required}")
    private String priority;

    public Task() {
    }

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
