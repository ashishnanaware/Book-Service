package com.mastek.bookservice.controller;

import com.mastek.bookservice.entity.Book;
import com.mastek.bookservice.payload.ApiResposnse;
import com.mastek.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;


    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBook(), OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.createBook(book), CREATED);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Book> getEmployeeById(@PathVariable Long id){

        return new ResponseEntity<>(bookService.getBookById(id), FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateEmployee(@PathVariable long id, @RequestBody Book book){

        Optional<Book> book1 = Optional.ofNullable(bookService.updateBook(id, book));
        return book1.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResposnse> deleteEmployee(@PathVariable Long id){
        ApiResposnse apiResposnse = bookService.deleteBook(id);
        if (apiResposnse != null && apiResposnse.getMessage().equals("Book deleted successfully")) {
            return new ResponseEntity<>(apiResposnse, NO_CONTENT);
        } else {
            return new ResponseEntity<>(apiResposnse, NOT_FOUND);
        }
    }


}
