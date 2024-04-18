package com.Ecommers.Products.Service;

import com.Ecommers.Products.Models.User;
import com.Ecommers.Products.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository){

        this.userRepository = userRepository;
    }
    public User saveUser(String name, String emailId) {
        User user = new User();
        user.setName(name);
        user.setEmail(emailId);
        userRepository.save(user);
        return user;

    }



    public User getByName(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.findByName(name).get();

    }
}
