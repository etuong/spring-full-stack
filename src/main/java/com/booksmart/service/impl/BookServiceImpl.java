package com.booksmart.service.impl;

import com.booksmart.entity.Book;
import com.booksmart.repository.BookRepository;
import com.booksmart.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        List<Book> bookList = (List<Book>) bookRepository.findAll();
        return bookList;
    }

    public Book findOne(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
