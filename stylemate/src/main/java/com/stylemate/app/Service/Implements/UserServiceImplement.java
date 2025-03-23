package com.stylemate.app.Service.Implements;
import com.stylemate.app.Entity.User;
import com.stylemate.app.Repository.UserRepository;
import com.stylemate.app.Service.GenericService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserServiceImplement implements GenericService<User, Integer> {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Override
    public String create(User entity) {
        User user = new User ();

        user.setName(entity.getName());

        Optional<User> existUser = userRepository.findByEmail(entity.getEmail());
        if (existUser.isPresent()){
            return "Email already registered";
        }

        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());

        userRepository.save(user);
        return "Created Successfully";
    }

    @Override
    public String update(Integer id, User entity) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found!"));
        
        user.setName(entity.getName());

        Optional<User> existUser = userRepository.findByEmail(entity.getEmail());
        if(existUser.isPresent() && !existUser.get().getId().equals(user.getId())){
            return "Email already registered";
        }

        user.setEmail(entity.getEmail());
        userRepository.save(user);

        return "Updated Successfully";
    }

    @Override
    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found!"));
        userRepository.delete(user);
    }
    
}
