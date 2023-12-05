package com.mastek.bookservice.service;

import com.mastek.bookservice.entity.Book;
import com.mastek.bookservice.payload.ApiResposnse;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    Book createBook(Book book);
    Book getBookById(Long id);
    Book updateBook(long id, Book book);
    ApiResposnse deleteBook(Long id);
}
