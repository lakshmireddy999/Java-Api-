package com.internshipproject.project.Repository;
import java.util.*;
import com.internshipproject.project.Entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contacts,Long> {
    List<Contacts> findAllByUserId(long userId);

    Contacts findOneById(long id);

    void deleteById(long id);
}
