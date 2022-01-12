package com.bridgelabz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailsDTO {
    private  String bookName;
    private String bookAuthorName;
    private String bookImage;
    private String bookPrice;
    private boolean bookAvailablity;
    private String bookDescription;
    private double bookRatings;
    private String bookReviews;
}
