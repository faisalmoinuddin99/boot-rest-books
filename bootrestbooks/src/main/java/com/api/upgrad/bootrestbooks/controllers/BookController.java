package com.api.upgrad.bootrestbooks.controllers;

import com.api.upgrad.bootrestbooks.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/books")
    public Book getBookDetails(){
        Book b = new Book() ;
        b.setBookId(1);
        b.setBookName("The kite runner");
        b.setAuthor("Khalid Hussani");

        return b ;
    }
}
