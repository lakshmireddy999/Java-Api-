package com.internshipproject.project;

import java.math.*;
import org.springframework.web.bind.annotation.*;
import java.sql.DriverManager;
import java.sql.*;
import java.lang.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;

import lombok.*;
@Data
class user {
    String id;
    String firstName;
    String lastName;
    String age;
    String timings;
    String mobile;
}

@CrossOrigin
@RestController
public class userDetails {

    @GetMapping("/user/data")
    public ArrayList<user> getData() {
        ArrayList<user> ans= new ArrayList<>();
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "password");
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery("select * from yoga");
            while (result.next()) {
                user u1=new user();
                u1.id=result.getString("id");
                u1.firstName=result.getString("firstName");
                u1.lastName=result.getString("LastName");
                u1.age=result.getString("Age");
                u1.timings=result.getString("Timing");
                u1.mobile=result.getString("Mobile");
                ans.add(u1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ans;
    }

}
