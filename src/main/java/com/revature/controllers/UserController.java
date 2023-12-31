package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUserHandler(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public Optional<User> getUserById(
            @PathVariable("id") int id
    ){
        return userService.getUserById(id);
    }

    @GetMapping("{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public User createUserHandler(@RequestBody User u){
        return userService.createUser(u);
    }

    @PutMapping
    public User updateUserHandler(@RequestBody User u){
        return userService.updateUser(u);
    }

    @PutMapping ("{id}")
    public User updateUserByIdHandler(
            @PathVariable("id") int id,
            @RequestBody User u
    ){
        return userService.updateUserById(id,u);
    }



}