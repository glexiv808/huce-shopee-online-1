package com.huce.shopee_online.controllers;


import com.huce.shopee_online.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setEmail("admin@gmail.com");
        user.setActive(true);
        user.setPhone("+8496451243");
        user.setPassword("Abcd12345678");
        return  user;

    }

    @PostMapping
    public User createUser(@RequestBody User user){

        return user;

    }
}
