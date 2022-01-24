package com.bridgelabz.service;

import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.dto.WishlistDTO;
import com.bridgelabz.exception.custom.BookNotFoundException;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.Wishlist;
import com.bridgelabz.repository.BookStoreRepository;
import com.bridgelabz.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService implements IWishlistService {
    private static final String BOOK_NOT_FOUND = "Book Details Not Found";
    private static final String ADDED_TO_WISHLIST = "Book Added To Wishlist";
    private static final String REMOVED_FROM_WISHLIST = "Book Removed From Wishlist";
    private static final String NOT_FOUND = "Id is Not Found";

    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Override
    public List<Wishlist> getAllWishlist() {
        return wishlistRepository.findAll();
    }

    @Override
    public ResponseDTO addToWishlist(WishlistDTO wishlistDTO) {
        Book bookDetails = checkIdForBook(wishlistDTO.bookID);
        Wishlist wishlist = new Wishlist();
        wishlist = wishlistRepository.save(wishlist);
        bookDetails.setWishlist(wishlist);
        bookStoreRepository.save(bookDetails);
        return new ResponseDTO(HttpStatus.CREATED, ADDED_TO_WISHLIST);
    }

    @Override
    public ResponseDTO removeWishlist(int wishlistID) {
        Wishlist wishlist = checkIdForWishlist(wishlistID);
        wishlistRepository.delete(wishlist);
        return new ResponseDTO(HttpStatus.ACCEPTED, REMOVED_FROM_WISHLIST);
    }

    public Book checkIdForBook(int bookId) {
        return bookStoreRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId + " " + BOOK_NOT_FOUND));
    }

    public Wishlist checkIdForWishlist(int wishlistID) {
        return wishlistRepository.findById(wishlistID)
                .orElseThrow(() -> new BookNotFoundException(wishlistID + " " + NOT_FOUND));
    }

}
