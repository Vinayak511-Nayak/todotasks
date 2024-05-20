package com.example.todotasks.model;
import com.example.todotasks.dto.Taskdto;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "username")
    public String username;
     @Column(name="email")
     String email;
    @Column(name = "password")
    public String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
     List<Task> task;
     public  User()
     {
     }
     public User(String username, String email, String password)
     {
         this.username=username;
         this.email=email;
         this.password=password;
     }
}

