package com.stylemate.app.Controller.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stylemate.app.Controller.GenericController;
import com.stylemate.app.Entity.User;
import com.stylemate.app.Repository.UserRepository;
import com.stylemate.app.Service.Implements.UserServiceImplement;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
            String response = userService.create(entity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatus());
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody User entity) {
        try {
            String response = userService.update(id, entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>("Update Failed : " + e.getReason() , HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>("Delete Failed : " + e.getReason(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
