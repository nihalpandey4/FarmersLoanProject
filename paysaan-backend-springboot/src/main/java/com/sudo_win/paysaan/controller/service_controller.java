package com.sudo_win.paysaan.controller;

import com.sudo_win.paysaan.models.User;
import com.sudo_win.paysaan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class service_controller {
    @Autowired
    UserRepository repository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @CrossOrigin(origins="*")
    @GetMapping("/get/{mobileNumber}")
    public User get_user(@PathVariable("mobileNumber") Long mobileNo){
        return repository.findByPhoneNo(mobileNo);
    }
    @CrossOrigin(origins="*")
    @PostMapping("/adduser")
    public User addUser(@RequestBody User newuser){
        String hashedPassword = passwordEncoder.encode(newuser.getPassword());
        newuser.setPassword(hashedPassword);
        repository.save(newuser);
        return newuser;
    }
    @CrossOrigin(origins="*")
    @GetMapping("/getallusers")
    public Iterable<User> getAllUsers(){
        return repository.findAll();
    }
}
