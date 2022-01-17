package com.bridgelabz.service;

import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.dto.CartDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.exception.custom.BookNotFoundException;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.Cart;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface ICartService {

    public List<Cart> getCartDetails();

    public ResponseDTO addToCart(CartDTO cartDTO);

    public ResponseDTO deleteCartDetails(int cartID);
}
