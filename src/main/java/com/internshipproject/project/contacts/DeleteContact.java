package com.internshipproject.project.contacts;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@RestController
@CrossOrigin
public class DeleteContact {

    @RequestMapping(path = "contacts/delete",consumes = "application/json",method = RequestMethod.POST)
    public static LoginOutput updateContact(@RequestBody Contacts c1)
    {
        LoginOutput out = new LoginOutput();

        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "password");
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery("select * from contacts where name='" + c1.getName() + "'");
            if(result.wasNull())
            {
                out.status="failed";
                out.error="contact doesn't exist";
                return out;
            }
            st.executeUpdate("delete from contacts where name='"+ c1.getName()+"';");
             result = st.executeQuery("select * from contacts where name='" + c1.getName() + "'");
            if(result.wasNull())
            {
                out.status="success";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return out;
    }
}
