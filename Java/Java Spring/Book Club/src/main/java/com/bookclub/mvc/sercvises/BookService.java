package com.bookclub.mvc.sercvises;

import com.bookclub.mvc.models.Book;
import com.bookclub.mvc.models.User;
import com.bookclub.mvc.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> allBook() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) {

            return bookRepository.save(book);
    }

    public List<Book> booknotBorrowed(User currentUser) {
        return bookRepository.findAllByBorrower(currentUser);
    }

    public List<Book> bookBorrowed(User currentUser) {
        return bookRepository.findAllByBorrowerNotContains(currentUser);
    }
    public List<Book> unborrowedBooks(User user){
        return bookRepository.findByBorrowerIdIsOrUserIdIs(null, user.getId());
    }

    public List<Book> borrowedBooks(User user){
        return bookRepository.findByBorrowerIdIs(user.getId());
    }
    public void addBorrower(Book book, User user) {
        book.setBorrower(user);
        bookRepository.save(book);
    }

}


//    public Book findBookById(Long id) {
//        return bookRepository.findById(id);
//    }
//}
