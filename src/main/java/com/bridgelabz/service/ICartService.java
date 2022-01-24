package com.bridgelabz.service;

import com.bridgelabz.dto.CartDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.model.Cart;

import java.util.List;

public interface ICartService {

    List<Cart> getCartDetails();

    ResponseDTO addToCart(CartDTO cartDTO);

    ResponseDTO deleteCartDetails(int cartID);
}
