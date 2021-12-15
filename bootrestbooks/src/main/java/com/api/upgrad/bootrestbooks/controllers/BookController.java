package com.api.upgrad.bootrestbooks.controllers;

import com.api.upgrad.bootrestbooks.entities.Book;
import com.api.upgrad.bootrestbooks.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookingService bookingService ;

    // Get All Books present in Array List
    @GetMapping("/books")
   public List<Book> getAllBooks(){
        return this.bookingService.getAllBooks() ;
    }

    // Get Book based on Id
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable(name = "id") int id) {
        return bookingService.getBookById(id) ;
    }

}
