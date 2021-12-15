package com.api.upgrad.bootrestbooks.dao;

import com.api.upgrad.bootrestbooks.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Integer> {
}
