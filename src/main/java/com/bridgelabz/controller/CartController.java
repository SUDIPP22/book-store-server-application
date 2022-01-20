package com.bridgelabz.controller;

import com.bridgelabz.dto.CartDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.model.Cart;
import com.bridgelabz.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @GetMapping(value = "/details")
    public ResponseEntity<List<Cart>> getCartDetails() {
        return new ResponseEntity<>(cartService.getCartDetails(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDTO> addToCart(@RequestBody CartDTO cartDTO) {
        return new ResponseEntity<>(cartService.addToCart(cartDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteCartDetails(@PathVariable int id) {
        return new ResponseEntity<>(cartService.deleteCartDetails(id), HttpStatus.OK);
    }
}
