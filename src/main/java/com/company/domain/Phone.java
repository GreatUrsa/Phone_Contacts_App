package com.company.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Table(name = "phones")
@EqualsAndHashCode
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true)
    private String number;

    @ManyToOne()
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Phone(String number) {
        this.number = number;
    }

    public Phone() {
    }

    public Phone(Long id, String number, Contact contact) {
        this.id = id;
        this.number = number;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}