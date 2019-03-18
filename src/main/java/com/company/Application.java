package com.company;

import com.company.domain.Contact;
import com.company.domain.Phone;
import com.company.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application /*implements CommandLineRunner*/ {
    /*@Autowired
    private ContactRepository contactRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   /* @Override
    public void run(String... args) {
        // Create a couple of Book and BookCategory
        contactRepository.save(new Contact("Cobtact 1", new Phone("0956742324"), new Phone("0987564315")));
        contactRepository.save(new Contact("Cobtact 2", new Phone("0975463723")));
    }*/
}
