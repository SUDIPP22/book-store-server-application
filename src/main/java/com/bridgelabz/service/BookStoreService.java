package com.bridgelabz.service;

import com.bridgelabz.builder.BookStoreBuilder;
import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.exception.custom.BadRequestException;
import com.bridgelabz.exception.custom.BookNotFoundException;
import com.bridgelabz.model.Book;
import com.bridgelabz.repository.BookStoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Slf4j
public class BookStoreService implements IBookStoreService {

    private static final String BOOK_NOT_FOUND = "There is no such book by the id :";
    private static final String BOOK_DETAILS_ADDED = "Book details are added successfully";
    String line = "";

    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Autowired
    private BookStoreBuilder bookStoreBuilder;

    @Override
    public List<Book> getAllBookDetails() {
        return bookStoreRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "book_details", key = "#id")
    public Book findBookDetailsById(int id) {
        log.info("getBookDetailsById() is called by id --> " + id);
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

    @Override
    public ResponseDTO saveBookData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new
                    FileReader("src/main/resources/books_data.csv"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Book bookEntity = new Book();
                bookEntity.setBookAuthorName(data[1].replaceAll("'", ""));
                bookEntity.setBookName(data[2].replaceAll("'", ""));
                bookEntity.setQuantity(data[3]);
                bookEntity.setBookImage(data[4]);
                bookEntity.setBookPrice(data[5]);
                IntStream.range(7, data.length - 1).forEach(column -> data[6] += "," + data[column]);
                bookEntity.setBookDescription(data[6]);
                bookStoreRepository.save(bookEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseDTO(HttpStatus.ACCEPTED, BOOK_DETAILS_ADDED);
    }

}
