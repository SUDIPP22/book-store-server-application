package com.bridgelabz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailsDTO {
    @NotNull(message = "Author name should not be empty")
    @Pattern(regexp = "^[A-Z][a-z]{2,}[ ][A-z][a-z]{2,}$", message = "Name is invalid")
    private String bookAuthorName;

    @NotNull(message = "Book name should not be empty")
    private String bookName;

    private String quantity;

    @NotNull(message = "Image should not be empty")
    private String bookImage;

    @NotNull(message = "Price should not be empty")
    private String bookPrice;

    @NotNull(message = "Description should not be empty")
    @Size(message = "Description should be within 10000 words", max = 10000)
    private String bookDescription;

}
