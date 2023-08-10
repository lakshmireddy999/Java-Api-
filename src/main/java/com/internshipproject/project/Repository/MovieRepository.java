package com.internshipproject.project.Repository;

import com.internshipproject.project.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
