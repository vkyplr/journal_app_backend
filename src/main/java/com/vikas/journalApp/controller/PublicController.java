package com.vikas.journalApp.controller;

import com.vikas.journalApp.entity.User;
import com.vikas.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/public"))
public class PublicController {

    @Autowired
    UserService userService;

    @PostMapping("create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.saveNewUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("health-check")
    public String healthCheck() {
        return "OK";
    }
}
