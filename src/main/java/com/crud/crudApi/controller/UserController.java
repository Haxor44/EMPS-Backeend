package com.crud.crudApi.controller;

import com.crud.crudApi.model.User;
import com.crud.crudApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
//@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUSer")
    public String addUSer(@RequestBody User user){
        userService.addUSer(user);
        return "User added successfully!!!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PutMapping("/user/{id}")
    public Optional<User> updateUser(@RequestBody User user, @PathVariable int id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

}
