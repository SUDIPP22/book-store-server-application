package com.bridgelabz.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CartDTO {
    @NotNull(message = "Book Id should not be empty")
    private int bookId;
    @NotNull(message = "Book Quantity should not be empty")
    private int bookQuantity;
}
