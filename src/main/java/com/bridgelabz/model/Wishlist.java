package com.bridgelabz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishListID;

    @OneToMany(mappedBy="wishlist")
    @JsonIgnoreProperties(value = "wishlist")
    private List<Book> book;
}
