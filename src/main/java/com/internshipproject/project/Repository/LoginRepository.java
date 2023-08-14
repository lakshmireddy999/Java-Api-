package com.internshipproject.project.Repository;

import com.internshipproject.project.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Login findOneByUserName(String userName);

    Login findOneByUserNameAndPassword(String userName,String password);
}
