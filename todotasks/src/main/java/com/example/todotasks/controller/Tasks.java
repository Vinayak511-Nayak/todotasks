package com.example.todotasks.controller;

import com.example.todotasks.dto.Taskdto;
import com.example.todotasks.model.Task;
import com.example.todotasks.security.JwtUtil;
import com.example.todotasks.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class Tasks {
    @Autowired
    TasksService tasksService;
    @PostMapping("/add")
    public String createTask(@RequestBody Taskdto body, @RequestHeader("Authorization") String bearer_token)
    {
        JwtUtil jwtUtil=new JwtUtil();
      String username=  jwtUtil.get_user(bearer_token);
        System.out.println("todo branch merge conflict?");
        return tasksService.createTask(body, username);
    }

    @GetMapping("/{id}")
    public Optional<Task> getAllTask(@PathVariable("id") int user_id)
    {
       return tasksService.getAllTask(user_id);
    }
}
