package com.example.todotasks.model;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    int id;
    String title;
    String description;
    @ManyToOne
    @JoinColumn(name = "uid",nullable = false)
    public User user;

    public Task(){

    }

    public Task(String title, String description,User user)
    {
        this.title=title;
        this.description=description;
        this.user=user;
    }
}
