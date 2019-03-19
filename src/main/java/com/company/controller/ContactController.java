package com.company.controller;

import com.company.domain.Contact;
import com.company.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
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

    @GetMapping({"/{id}"})
    public Contact getOne(@PathVariable("id") Long id, Contact contact) {
        return contact;
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable("id") Long id, Contact contactFromDb,
                          @RequestBody Contact contact) {
        BeanUtils.copyProperties(contact, contactFromDb, "id");
        return contactRepository.save(contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, Contact contact) {
        contactRepository.delete(contact);
    }
}
