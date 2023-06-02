package com.internshipproject.project.contacts;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
@CrossOrigin
public class Login {
    @RequestMapping(path = "contacts/login",consumes = "application/json", method = RequestMethod.POST)
    public static LoginOutput login(@RequestBody LoginInput l1)
    {
        LoginOutput out = new LoginOutput();
        try
        {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "password");
            Statement st = connect.createStatement();

            ResultSet result = st.executeQuery("select * from contactLogin where userName='" + l1.getUserName() + "'");
            if(result.wasNull())
            {
                out.error="Invalid userName or Password";
                out.status="failed";
                return out;
            }
            while (result.next()) {
                if(!result.getString("password").equals(l1.getPassword()))
                {
                    out.error="Invalid Password";
                    out.status="failed";
                    return out;
                }
                else {
                    out.status="Success";

                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return out;
    }
}
