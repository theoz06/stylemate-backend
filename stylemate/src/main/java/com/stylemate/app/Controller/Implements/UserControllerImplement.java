package com.stylemate.app.Controller.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stylemate.app.Controller.GenericController;
import com.stylemate.app.Entity.User;
import com.stylemate.app.Service.Implements.UserServiceImplement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/user")
public class UserControllerImplement implements GenericController<User, Integer> {

    @Autowired
    private UserServiceImplement userService;


    @Override
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody User entity) {
        try {
            userService.create(entity);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(null, e.getStatus());
        }
    }

    @Override
    public ResponseEntity<User> update(Integer id, User entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
