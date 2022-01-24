package com.bridgelabz.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP")
    private String zip;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "LANDMARK")
    private String landmark;

    @Column(name = "TYPE")
    private String type;
}