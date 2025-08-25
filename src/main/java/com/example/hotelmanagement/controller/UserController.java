package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.entities.User;
import com.example.hotelmanagement.repositories.UserRepository;
import com.example.hotelmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("register/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if(isUserPresent(user)){
            return new ResponseEntity<>("User already exists.....", HttpStatus.BAD_REQUEST);
        }
        User userAdded = userService.addUser(user);
        return ResponseEntity.ok(userAdded);
    }
    private boolean isUserPresent(User user) {
        return false;
    }
}
