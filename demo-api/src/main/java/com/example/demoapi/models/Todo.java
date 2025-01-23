package com.example.demoapi.models;

public class Todo {
    private String id;
    private String title;
    private Boolean completed;
    // Add Deleted

    // Constructors
    public Todo() {
    }

    public Todo(String id, String title, Boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getters and setters

    // ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Completed
    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}
