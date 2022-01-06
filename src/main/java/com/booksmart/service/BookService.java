package com.booksmart.service;

import com.booksmart.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findOne(Long id);

    Book save(Book book);
}
