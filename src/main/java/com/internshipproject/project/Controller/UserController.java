package com.internshipproject.project.Controller;

import com.internshipproject.project.Entity.User;
import com.internshipproject.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;

@Service
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/user/add", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<String> updateData(@RequestBody User u1) {
        User user = User.builder()
                .age(u1.getAge())
                .firstName(u1.getFirstName())
                .lastName(u1.getLastName())
                .timings(u1.getTimings())
                .mobile(u1.getMobile())
                .build();
        userRepository.save(user);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(path = "user/get", method = RequestMethod.GET)
    public ArrayList<User> getData() {
        return new ArrayList<>(userRepository.findAll());
    }
}
