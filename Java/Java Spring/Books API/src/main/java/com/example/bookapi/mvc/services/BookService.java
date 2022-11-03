package com.example.bookapi.mvc.services;
import com.example.bookapi.mvc.models.Book;
import com.example.bookapi.mvc.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository; //related to dependency injection

    public BookService(BookRepository bookRepository) { //here we inject the service dependency in repository dependency
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id); // optional since it may not find nothing and to do not have error
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Optional<Book> book1 = bookRepository.findById(id);
        if(book1.isPresent()) {
            Book updateBook= book1.get();
            updateBook.setTitle(title);
            updateBook.setDescription(desc);
            updateBook.setLanguage(lang);
            updateBook.setNumberOfPages(numOfPages);

            return bookRepository.save(updateBook);
        }
        else {
            return null;
        }
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
// find all
// find by id
// greate
//update all by defult in all services
