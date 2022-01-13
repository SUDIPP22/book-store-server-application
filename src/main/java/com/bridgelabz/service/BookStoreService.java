package com.bridgelabz.service;

import com.bridgelabz.builder.BookStoreBuilder;
import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.exception.custom.BadRequestException;
import com.bridgelabz.exception.custom.BookNotFoundException;
import com.bridgelabz.model.Book;
import com.bridgelabz.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreService implements IBookStoreService {

    private static final String BOOK_NOT_FOUND = "There is no such book by the id :";
    private static final String BOOK_DETAILS_ADDED = "Book details are added successfully";
    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Autowired
    private BookStoreBuilder bookStoreBuilder;

    @Override
    public List<Book> getAllBookDetails() {
        return bookStoreRepository.findAll();
    }

    @Override
    public Book findBookDetailsById(int id) {
        return bookStoreRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(BOOK_NOT_FOUND + " " + id));
    }

    @Override
    public ResponseDTO addNewBook(BookDetailsDTO bookDetailsDTO) {
        if (bookDetailsDTO == null) {
            throw new BadRequestException("Book Details should not be empty");
        }
        Book bookEntity = new Book();
        bookEntity = bookStoreBuilder.buildBookEntity(bookDetailsDTO, bookEntity);
        bookStoreRepository.save(bookEntity);
        return new ResponseDTO(HttpStatus.CREATED, BOOK_DETAILS_ADDED);
    }
}
