package com.api.upgrad.bootrestbooks.services;

import com.api.upgrad.bootrestbooks.dao.BookDao;
import com.api.upgrad.bootrestbooks.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "bookService")
public class BookService {

    // we need BookDao to interact with Database
    @Autowired
    BookDao bookDao ;

    // Get all books
    public List<Book> getAllBooks(){
        return bookDao.findAll() ;
    }

    // Adding the Book
    public Book addBook(Book book){
        return bookDao.save(book) ;
    }

    // Get Book By ID
    public Book getBookById(int id){
        Book b = bookDao.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No Book Found for this Id:" +id)
                ) ;
        return b;
    }

    // Delete Book By Id
    public void deleteBook(int id){
        bookDao.deleteById(id);
    }

    // Update Book
    public Book updateBook(Book book, int id){
        book.setBookId(id);
        return bookDao.save(book) ;
    }
}
