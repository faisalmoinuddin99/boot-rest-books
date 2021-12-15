package com.api.upgrad.bootrestbooks.services;

import com.api.upgrad.bootrestbooks.entities.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookService {

    // Assume Array as a DataBase as for now
    public static final List<Book> list = new ArrayList<>() ;

    static {
        list.add(new Book(1,"Java Complete Reference", "xyz")) ;
        list.add(new Book(2,"Python Complete Reference", "abc")) ;
        list.add(new Book(3,"C Complete Reference", "lmn")) ;
        list.add(new Book(4,"C++ Complete Reference", "pqr")) ;
    }

    // get all books service
    public List<Book> getAllBooks(){
        return list ;
    }

    // get book by id service
    public Book getBookById(int id){

        return list.stream().filter(e -> e.getBookId() == id).findFirst().get() ;
    }

    // Create Resource [ POST METHOD ]
    public Book addBook(Book book){
        list.add(book) ;
        return book ;
    }
}
