package com.example.todotasks.service;

import com.example.todotasks.dto.Userdto;
import com.example.todotasks.model.User;
import com.example.todotasks.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
//import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class Userservice {
    @Autowired
    public UserRepo users;
   // public  ResponseEntity<String> loginUser(String username, String password) {

    public  boolean loginUser(String username,String password) {

         Optional<User> user = users.getUsername(username);

         if(user.isPresent())
          {
           String pass= user.get().password;
           if(pass.equals(password))
            //   return ResponseEntity.ok("Successfully logged In");
               return true;
          // return ResponseEntity.badRequest().body("Incorrect Password");
          }
            // return ResponseEntity.badRequest().body("User not found");
        return false;


    }

    public  ResponseEntity<String>  createUser(Userdto user)
    {  try{
           User user1=new User(user.username,user.email,user.password);

        users.save(user1);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created user");
    }
    catch (DataIntegrityViolationException e) {
        // Handle data integrity violation exception
        // This may occur if there's a constraint violation (e.g., unique constraint)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Data could not be saved due to integrity violation");
    } catch (Exception e) {
        // Handle other exceptions
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Data could not be saved due to an unexpected error");
    }

    }


}
