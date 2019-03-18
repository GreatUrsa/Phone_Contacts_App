package com.company.controller;

import com.company.domain.Contact;
import com.company.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact")
public class ContactController {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping
    public List<Contact> list() {
        return contactRepository.findAll();
    }

    @GetMapping({"{id}"})
    public Contact getOne(@PathVariable("id") Contact contact) {
        return contact;
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }
}
