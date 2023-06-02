package com.internshipproject.project.contacts;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@RestController
@CrossOrigin
public class GetContacts {
    @GetMapping(path = "contacts/get")
    public static ArrayList<Contacts> getContacts()
    {
        ArrayList<Contacts> out= new ArrayList<>();
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "password");
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery("select * from yoga");
            while (result.next()) {
                Contacts obj = new Contacts();
                obj.name=result.getString("userName");
                obj.mobile=result.getString("mobile");
                out.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return out;
    }
}
