package com.internshipproject.project.contacts;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateContact {
    @RequestMapping(path = "contacts/update",consumes = "aplication/json",method = RequestMethod.POST)
    public static Contacts updateContact(@RequestBody Contacts c1)
    {
        Contacts out = new Contacts();
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "password");
            Statement st = connect.createStatement();
            st.executeUpdate("insert into contacts(name,mobile) values('" + c1.getName()
                    + "','" + c1.getMobile()+ "');");
            ResultSet result = st.executeQuery("select * from contacts where name='" + c1.getName() + "'");
            while (result.next()) {
                out.name = result.getString("name");
                out.mobile=result.getString("mobile");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return out;
    }
}
