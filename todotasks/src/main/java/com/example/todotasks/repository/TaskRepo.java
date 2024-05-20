package com.example.todotasks.repository;

import com.example.todotasks.controller.User;
import com.example.todotasks.dto.Taskdto;
import com.example.todotasks.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepo extends CrudRepository<Task,Long> {

    @Query(value="SELECT t FROM Task t WHERE t.id = ?1",nativeQuery = true)
    Optional<Task> getAllTasks(int id);

}
