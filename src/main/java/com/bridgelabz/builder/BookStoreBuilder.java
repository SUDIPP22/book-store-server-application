package com.bridgelabz.builder;

import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.model.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BookStoreBuilder {
    public Book buildBookEntity(BookDetailsDTO bookDetailsDTO, Book book) {
        BeanUtils.copyProperties(bookDetailsDTO, book);
        return book;
    }
}
