package com.mastek.bookservice.service.impl;

import com.mastek.bookservice.entity.Book;
import com.mastek.bookservice.exception.ResourceNotFoundException;
import com.mastek.bookservice.payload.ApiResposnse;
import com.mastek.bookservice.repository.BookRepository;
import com.mastek.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Book> getAllBook() {
        return repository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id+" is not found"));
    }

    @Override
    public Book updateBook(long id, Book book) {
        if (repository.existsById(id)) {
            book.setId(id);

            return repository.save(book) ;
        }
        return repository.save(book);
    }

    @Override
    public ApiResposnse deleteBook(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return new ApiResposnse("Employee deleted successfully", NO_CONTENT);
        }else return new ApiResposnse("Resource not found", NOT_FOUND);
    }
}
