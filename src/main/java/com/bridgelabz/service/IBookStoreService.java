package com.bridgelabz.service;

import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.model.Book;

import java.util.List;

public interface IBookStoreService {
    List<Book> getAllBookDetails();

    Book findBookDetailsById(int id);

    ResponseDTO addNewBook(BookDetailsDTO bookDetailsDTO);
}
