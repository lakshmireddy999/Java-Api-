package com.internshipproject.project;

import java.sql.Connection;
import java.sql.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
class Img
{
    String img;
}

@RestController
@RequestMapping
public class Image {
   
    @RequestMapping(path ="/user/update/image", consumes = "application/json", method = RequestMethod.POST)
    public String updateImage (@RequestBody Img i1)
    {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "password");
            Statement st = connect.createStatement();
            st.executeUpdate("insert into img_data(img) values('"+i1.getImg()+"');");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "success";

    }
}
