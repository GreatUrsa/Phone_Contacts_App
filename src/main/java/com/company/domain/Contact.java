package com.company.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Table(name = "contacts")
@EqualsAndHashCode(exclude = "phones")
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true)
    private String name;

    private String email;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<Phone> phones;


    public Contact(String name, String email, Phone... phones) {
        this.name = name;
        this.email = email;
        this.phones = Stream.of(phones).collect(Collectors.toSet());
        this.phones.forEach(x -> x.setContact(this));
    }

    public Contact() {
    }


    public Contact(Long id, String name, String email, Set<Phone> phones) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
