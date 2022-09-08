package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/name/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return this.userService.getUsersByName(name);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) throws Exception {
        return this.userService.getUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable String id) throws Exception {
        return this.userService.deleteUser(id);
    }

    @PostMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) throws Exception {
        return this.userService.updateUser(id, user);
    }
}
