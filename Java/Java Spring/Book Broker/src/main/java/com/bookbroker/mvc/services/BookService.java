package com.bookbroker.mvc.services;

import com.bookbroker.mvc.models.Book;
import com.bookbroker.mvc.models.User;
import com.bookbroker.mvc.repositories.BookRepository;
import com.bookbroker.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Book> allBook() {
        return bookRepository.findAll();
    }

    public List<Book> allNotborrowedBooks(){
        return bookRepository.borrowedbyIsNull();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book finadById(Long id) {
        return bookRepository.findById(id).get();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) {
            return bookRepository.save(book);

    }

    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

}