package com.bridgelabz.controller;

import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.model.Book;
import com.bridgelabz.service.BookStoreService;
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
}
