package com.stylemate.app.Service.Implements;
import com.stylemate.app.Entity.User;
import com.stylemate.app.Repository.UserRepository;
import com.stylemate.app.Service.GenericService;
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
    public User create(User entity) {
        User user = new User ();
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());

        User response = userRepository.save(user);
        return response;
    }

    @Override
    public User update(Integer id, User entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
