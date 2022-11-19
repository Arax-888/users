package com.mkrtumyan.users.controller;

import com.mkrtumyan.users.persistence.User;
import com.mkrtumyan.users.persistence.UserRepository;
import com.mkrtumyan.users.persistence.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> users = this.userRepository.findAll();
        if (users == null || users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        List<UserResponse> userResponses = new ArrayList<>();
        users.forEach(user -> userResponses.add(new UserResponse(user.getName(), user.getSurename(), user.getEmail())));
        return ResponseEntity.status(HttpStatus.OK).body(userResponses);
    }


    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserResponse userResponse) {
        User savedUser = this.userRepository.save(new User(userResponse.getName(), userResponse.getSurename(), userResponse.getEmail()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(savedUser.getName(), savedUser.getSurename(), savedUser.getEmail()));
    }
}
