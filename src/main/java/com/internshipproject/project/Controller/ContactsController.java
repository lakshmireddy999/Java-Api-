package com.internshipproject.project.Controller;

import com.internshipproject.project.Entity.Contacts;
import com.internshipproject.project.Entity.Output;
import com.internshipproject.project.Repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@Service
@CrossOrigin
public class ContactsController {
    @Autowired
    ContactsRepository contactsRepository;

    @RequestMapping(path = "contacts/add", consumes = "application/json", method = RequestMethod.POST)
    public Contacts addContact(@RequestBody Contacts contacts) {
        Contacts contacts1 = new Contacts();

        contacts1.setFirstName(contacts.getFirstName());
        contacts1.setLastName(contacts.getLastName());
        if (contacts.getEmail() != null) {
            contacts1.setEmail(contacts.getEmail());
        }
        contacts1.setUserId(contacts.getUserId());
        contacts1.setMobile(contacts.getMobile());

        return contactsRepository.save(contacts1);
    }

    @RequestMapping(path = "contacts/get", consumes = "application/json", method = RequestMethod.POST)
    public List<Contacts> getContacts(@RequestBody Contacts contacts) {
        return new ArrayList<>((Collection) contactsRepository.findAllByUserId(contacts.getUserId()));
    }

    @RequestMapping(path = "contacts/edit", consumes = "application/json", method = RequestMethod.POST)
    public Contacts editContact(@RequestBody Contacts contacts) {
        Contacts contacts1 = contactsRepository.findOneById(contacts.getId());

        contacts1.setFirstName(contacts.getFirstName());
        contacts1.setLastName(contacts.getLastName());
        contacts1.setMobile(contacts.getMobile());
        if (contacts.getEmail() != null) {
            contacts1.setEmail(contacts.getEmail());
        }
        contactsRepository.save(contacts1);

        return contacts1;
    }

    @RequestMapping(path = "contacts/delete", consumes = "application/json", method = RequestMethod.POST)
    public Output deleteContact(@RequestBody Contacts contacts) {
        Output output = new Output();

        if (contactsRepository.findOneById(contacts.getId()) == null) {
            output.setStatus("failed");
            output.setError("Not a Valid Id");
            return output;
        }

        long id = contacts.getId();
        contactsRepository.deleteById(contacts.getId());
        if (contactsRepository.findOneById(id) == null) {
            output.setStatus("success");
        } else {
            output.setStatus("failed");
            output.setError("Not a Valid Id");
        }

        return output;
    }
}
