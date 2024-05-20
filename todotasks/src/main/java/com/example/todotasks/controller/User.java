package com.example.todotasks.controller;
import com.example.todotasks.dto.Userdto;
import com.example.todotasks.security.JwtUtil;
import com.example.todotasks.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/user")
public class User {
@Autowired
 Userservice userservice;
  @PostMapping("/login")
   public String loginUser(@RequestBody  Userdto user)
   {    System.out.println("hello user");
       JwtUtil jwt=new JwtUtil();
      String token= jwt.generate_token(user.username);
      System.out.println(token);
       if(userservice.loginUser(user.username,user.password))
           return token;

       return "failed to login user";

   }

    @PostMapping("/register")
    public  ResponseEntity<String> register(@RequestBody Userdto user) {
      return  userservice.createUser(user);

    }
}
