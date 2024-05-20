package com.example.todotasks.dto;

import jakarta.persistence.*;

public class Taskdto {

    @Id
    @GeneratedValue
   public int id;
   public String title;
   public String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid") // Name of the foreign key column
    public Userdto user;

}
