package com.example.todotasks.service;
import com.example.todotasks.model.Task;
import com.example.todotasks.dto.Taskdto;
import com.example.todotasks.model.User;
import com.example.todotasks.repository.TaskRepo;
import com.example.todotasks.repository.UserRepo;
import com.example.todotasks.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class TasksService {
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    UserRepo userRepo;
    public String createTask(Taskdto tasks,String name)
    {
       Optional<User> optionalUser= userRepo.getUsername(name);
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
         Task task=new Task(tasks.title,tasks.description,user);
         taskRepo.save(task);

        return "Succefully created task";
    }

    public Optional<Task> getAllTask(int id)
    {
        return  taskRepo.getAllTasks(id);

    }
}
