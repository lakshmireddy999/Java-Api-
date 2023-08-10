package com.internshipproject.project.Repository;

import com.internshipproject.project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
