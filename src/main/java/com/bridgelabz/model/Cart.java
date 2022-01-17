package com.bridgelabz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    private int bookQuantity;
    private double bookPrice;

    @OneToOne(cascade = CascadeType.ALL)
    private Book book;
}
