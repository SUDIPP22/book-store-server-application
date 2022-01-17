package com.bridgelabz.controller;

import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.dto.CartDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.Cart;
import com.bridgelabz.service.BookStoreService;
import com.bridgelabz.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/book-store")
public class BookStoreController {
    @Autowired
    private BookStoreService bookStoreService;

    @Autowired
    private CartService cartService;

    @PostMapping(value = "/details")
    public ResponseEntity<ResponseDTO> addNewBook(
            @Valid
            @RequestBody BookDetailsDTO bookDetailsDTO
    ) {
        return new ResponseEntity<>(bookStoreService.addNewBook(bookDetailsDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/details")
    public ResponseEntity<List<Book>> getAllBook() {
        return new ResponseEntity<>(bookStoreService.getAllBookDetails(), HttpStatus.OK);
    }

    @GetMapping(value = "/details/{id}")
    public ResponseEntity<Book> getBookDetailsById(
            @PathVariable int id
    ) {
        return new ResponseEntity<>(bookStoreService.findBookDetailsById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/cartDetails")
    public ResponseEntity<List<Cart>> getCartDetails() {
        return new ResponseEntity<>(cartService.getCartDetails(), HttpStatus.OK);
    }

    @PostMapping(value = "/add-to-cart")
    public ResponseEntity<ResponseDTO> addToCart(@RequestBody CartDTO cartDTO) {
        return new ResponseEntity<>(cartService.addToCart(cartDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-cart-details/{id}")
    public ResponseEntity<ResponseDTO> deleteCartDetails(@PathVariable int id) {
        return new ResponseEntity<>(cartService.deleteCartDetails(id), HttpStatus.OK);
    }
}
