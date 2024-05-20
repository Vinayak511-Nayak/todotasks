package com.example.todotasks.repository;
import com.example.todotasks.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepo extends CrudRepository <User, Integer>{
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> getUsername(String username);
    //Optional<User> findByUsername(String username);
};
