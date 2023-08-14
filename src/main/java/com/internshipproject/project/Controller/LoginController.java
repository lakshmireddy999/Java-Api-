package com.internshipproject.project.Controller;

import com.internshipproject.project.Entity.Login;
import com.internshipproject.project.Entity.Output;
import com.internshipproject.project.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    LoginRepository loginRepository;

    @RequestMapping(path = "contacts/login",consumes = "application/json",method = RequestMethod.POST)
    public Output login(@RequestBody Login login)
    {
        Login login1 = loginRepository.findOneByUserNameAndPassword(login.getUserName(),login.getPassword());

        Output output = new Output();
        if(login.getUserName().equals(login1.getUserName()) && login.getPassword().equals(login1.getPassword()))
        {
            output.setStatus("success");
            output.setId(login1.getId());
        }
        else
        {
            output.setStatus("failure");
            output.setError("user_name or password mismatch");
        }
        return output;
    }

}
