package com.example.todoapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;


@Entity
@Table(name = "tasks")
public class Task  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "tasks descriptions can't be empty")
    private String descriptions;
    private boolean done;
    @Column(name = "deadline", columnDefinition = "DATETIME")
    private LocalDateTime deadline;

    @Embedded
    private Audit audit = new Audit();


    public Task() {
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void updateFrom (final Task source) {
        descriptions = source.descriptions;
        done = source.done;
        deadline = source.deadline;

    }



}
