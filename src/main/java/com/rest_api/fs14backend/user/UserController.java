package com.rest_api.fs14backend.user;

import com.rest_api.fs14backend.exceptions.NotFoundException;
import com.rest_api.fs14backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        System.out.println("we are inside users");
        return userRepository.findAll();
    }
//    @PostMapping("/")
//    public User createOne (@RequestBody User user){
//        User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()));
//        userService.createOne(newUser);
//
//        return newUser;
//    }

    @PostMapping("/signin")
    public String login(@RequestBody AuthenticateRequest authenticateRequest){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getUsername(),
                        authenticateRequest.getPassword()
                )
        );

        User user = userRepository.findByUsername(authenticateRequest.getUsername());

        return jwtUtils.generateToken(user);
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {

        User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getFirstName());
        userService.createOne(newUser);
        return newUser;
    }

}