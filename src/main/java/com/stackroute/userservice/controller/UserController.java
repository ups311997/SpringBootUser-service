package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserServiceImpl userServiceImpl;
    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userServiceImpl.saveUser(user);
        return new ResponseEntity<User>(savedUser,HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List> getAllUsers(){
        List<User> allUsers= userServiceImpl.getAllUsers();
        return new ResponseEntity<List>(allUsers,HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User getUserById = userServiceImpl.getUserById(id);
        return new ResponseEntity<User>(getUserById,HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<List> deleteUser(@PathVariable int id){
        userServiceImpl.deleteUser(id);
        return new ResponseEntity<List>(userServiceImpl.getAllUsers(),HttpStatus.OK);

    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
        User updatedUser = userServiceImpl.updateUser(id,user);
        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);

    }
}
