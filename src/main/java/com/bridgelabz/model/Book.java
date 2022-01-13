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
    private String bookName;
    private String bookAuthorName;
    private String bookImage;
    private double bookPrice;
    private boolean bookAvailablity;
    private String bookDescription;
    private double bookRatings;
    private String bookReviews;
}
