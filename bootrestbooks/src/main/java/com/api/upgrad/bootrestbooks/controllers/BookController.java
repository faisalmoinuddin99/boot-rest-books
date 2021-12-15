package com.api.upgrad.bootrestbooks.controllers;

import com.api.upgrad.bootrestbooks.entities.Book;
import com.api.upgrad.bootrestbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookingService ;

    // Get All Books present in Array List
    @GetMapping("/books")
   public List<Book> getAllBooks(){
        return this.bookingService.getAllBooks() ;
    }

    // Get Book based on ID
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable(name = "id") int id) {
        return bookingService.getBookById(id) ;
    }

    // Post new book
    @PostMapping("/books")
    public Book postNewBook(@RequestBody Book book){
        Book b = bookingService.addBook(book) ;
        return b ;
    }

    // Delete Book based on ID
    @DeleteMapping("/books/{id}")
    public List<Book> deleteBook(@PathVariable(name = "id") int id){
       
        return bookingService.deleteBook(id) ;
    }

    // Update Book
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable(name = "id")int id){
        bookingService.updateBook(book,id);
        return book ;
    }

}
