package com.internshipproject.project.yoga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Service
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(path ="/user/add", consumes = "application/json", method = RequestMethod.POST)
    public ArrayList<com.internshipproject.project.yoga.User> updateData(@RequestBody com.internshipproject.project.yoga.User u1) {
        User user = User.builder()
                .age(u1.getAge())
                .firstName(u1.getFirstName())
                .lastName(u1.getLastName())
                .timings(u1.getTimings())
                .mobile(u1.getMobile())
                .build();
        userRepository.save(user);
        return new ArrayList<>(userRepository.findAll());
    }

    @RequestMapping(path = "user/get",method = RequestMethod.GET)
    public ArrayList<com.internshipproject.project.yoga.User> getData() {
        return new ArrayList<>(userRepository.findAll());
    }
}
