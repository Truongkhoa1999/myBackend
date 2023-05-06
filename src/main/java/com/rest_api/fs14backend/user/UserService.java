package com.rest_api.fs14backend.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    public User createOne(User user) {
        return userRepository.save(user);
    }
    public User findByUsername(String username) {return userRepository.findByUsername(username);}
}
