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
public class updateUser {

    @RequestMapping(path ="/user/update", consumes = "application/json", method = RequestMethod.POST)
    public ArrayList<user> updateData(@RequestBody user u1) {
        ArrayList<user> ar = new ArrayList<>();
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "password");
            Statement st = connect.createStatement();
            st.executeUpdate("insert into yoga(firstName,lastName,age,Timing,Mobile) values('" + u1.getFirstName()
                    + "','" + u1.getLastName() + "','" + u1.getAge() + "','" + u1.getTimings() + "','" + u1.getMobile()
                    + "');");
            ResultSet result = st.executeQuery("select * from yoga where firstName='" + u1.getFirstName() + "'");
            while (result.next()) {
                u1.id = result.getString("id");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ar.add(u1);
        return ar;
    }
}
