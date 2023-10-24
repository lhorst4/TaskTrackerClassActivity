package com.example.tasktrackerapp;

import androidx.annotation.NonNull;

public class Task {
    String owner;
    String task;

    public Task(String owner, String task) {
        this.owner = owner;
        this.task = task;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @NonNull
    @Override
    public String toString() {
        return task + " by " + owner;
    }
}
