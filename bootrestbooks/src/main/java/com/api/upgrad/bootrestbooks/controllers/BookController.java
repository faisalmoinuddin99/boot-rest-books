package com.api.upgrad.bootrestbooks.controllers;

import com.api.upgrad.bootrestbooks.entities.Book;
import com.api.upgrad.bootrestbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

   @Autowired
    BookService bookService ;

   @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
       List<Book> list = bookService.getAllBooks() ;
       if (list.size() <= 0){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
       }
       return ResponseEntity.status(HttpStatus.OK).body(list) ;
   }

   @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
       Book b = null ;
       try {
           b = bookService.addBook(book) ;
           System.out.println(b);
           return ResponseEntity.of(Optional.of(b)) ;
       } catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() ;
       }
   }

   @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(name = "id")int id){
       Book book = bookService.getBookById(id) ;

       if (book == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
       }
       return ResponseEntity.of(Optional.of(book)) ;
   }
   @DeleteMapping("/books/{id}")
    public ResponseEntity deleteBook(@PathVariable(name = "id")int id){
       try {
           bookService.deleteBook(id);

           return (ResponseEntity) ResponseEntity.status(HttpStatus.OK).build();
       } catch (Exception e){
           return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
   }

   @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable(name = "id") int id){
       try {
           bookService.updateBook(book,id) ;
           return ResponseEntity.ok().body(book) ;
       }catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() ;
       }
   }
}
