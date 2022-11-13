package com.bookbroker.mvc.repositories;

import com.bookbroker.mvc.models.Book;
import com.bookbroker.mvc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> borrowedbyIsNull();



}
