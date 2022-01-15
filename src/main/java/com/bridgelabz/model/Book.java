package com.bridgelabz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookAuthorName;
    private String bookName;
    private String bookImage;
    private String bookPrice;
    @Column(length = 10000)
    private String bookDescription;
    private String quantity;

}

