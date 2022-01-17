package com.bridgelabz.service;

import com.bridgelabz.builder.BookStoreBuilder;
import com.bridgelabz.dto.CartDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.exception.custom.BookNotFoundException;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.Cart;
import com.bridgelabz.repository.BookStoreRepository;
import com.bridgelabz.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {

    private static final String CART_DETAILS_ADDED = "Book Details Added To Cart";
    private static final String CART_DETAILS_REMOVED = "Book Details Removed From Cart";
    private static final String NOT_FOUND = "Record Not Found";
    private static final String BOOK_NOT_FOUND = "Book Details Not Found";

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Autowired
    private BookStoreBuilder bookStoreBuilder;

    @Override
    public List<Cart> getCartDetails() {
        return cartRepository.findAll();
    }

    @Override
    public ResponseDTO addToCart(CartDTO cartDTO) {
        Book book = checkIdForBook(cartDTO.getBookId());

        Cart cartEntity = new Cart();
        cartEntity.setBook(book);
        cartEntity.setBookPrice(book.getBookPrice()*cartDTO.getBookQuantity());
        cartEntity.setBookQuantity(cartDTO.getBookQuantity());

        cartRepository.save(cartEntity);
        return new ResponseDTO(HttpStatus.CREATED, CART_DETAILS_ADDED);
    }

    @Override
    public ResponseDTO deleteCartDetails(int cartID) {
        Cart cartDetails = checkIdForCart(cartID);
        cartRepository.delete(cartDetails);
        return new ResponseDTO(HttpStatus.CREATED, CART_DETAILS_REMOVED);
    }

    public Cart checkIdForCart(int cartID) {
        return cartRepository.findById(cartID)
                .orElseThrow(() -> new BookNotFoundException(cartID + " " + NOT_FOUND));
    }

    public Book checkIdForBook(int bookId) {
        return bookStoreRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId + "" + BOOK_NOT_FOUND));
    }
}
