package com.service.user.user.service.controller;

import jakarta.validation.Valid;
import com.service.user.user.service.entity.User;
import com.service.user.user.service.service.serviceImpl.ServiceUserImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/v1")
@RequiredArgsConstructor
public class ControllerUser {

    @Autowired
    private ServiceUserImpl serviceUserImpl;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> listUsers = serviceUserImpl.getAllUsers();
        return listUsers;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User userModel = serviceUserImpl.createUser(user);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        boolean isDeleted = serviceUserImpl.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@Valid @RequestBody User user){
        User userModel = serviceUserImpl.updateUser(id, user);
        return ResponseEntity.ok(userModel);
    }
}
