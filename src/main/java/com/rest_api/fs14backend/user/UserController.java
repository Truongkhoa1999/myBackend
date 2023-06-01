package com.rest_api.fs14backend.user;

import com.rest_api.fs14backend.exceptions.NotFoundException;
import com.rest_api.fs14backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PostMapping("/signin")
    public Map<String, String> login(@RequestBody AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getUsername(),
                        authenticateRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(authenticateRequest.getUsername());
        Map<String, String> token = new HashMap<>();
        token.put("token", jwtUtils.generateToken(user));
        return token;
    }

    @PostMapping("/signup")
    public Map<String, String> signup(@RequestBody User user) {
        User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getFirstName(), User.Role.ADMIN, user.getAvatar());
        userService.createOne(newUser);

        Map<String, String> token = new HashMap<>();
        token.put("token", jwtUtils.generateToken(newUser));
        return token;
    }


}