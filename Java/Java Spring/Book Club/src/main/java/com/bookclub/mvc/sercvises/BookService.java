package com.bookclub.mvc.sercvises;

//import com.bookclub.mvc.models.Book;
import com.bookclub.mvc.models.Book;
import com.bookclub.mvc.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> allBook() {
        return bookRepository.findAll();
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

    public Book updateBook(Book book, Long id) {
        Optional<Book> book1 = bookRepository.findById(id);
        if (book1.isPresent()) {
            Book updateBook= book1.get();
            return bookRepository.save(book);
        }
        else {
            return null;
        }

    }
}
