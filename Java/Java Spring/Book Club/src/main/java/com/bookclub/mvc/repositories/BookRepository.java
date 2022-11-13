package com.bookclub.mvc.repositories;

import com.bookclub.mvc.models.Book;
import com.bookclub.mvc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findAllByBorrower(User user);
    List<Book> findAllByBorrowerNotContains(User user);

    List<Book> findByUserIdIs(Long userId);
    List<Book> findByBorrowerIdIs(Long userId);
    List<Book> findByBorrowerIdIsOrUserIdIs(Long borrowerID, Long userId);

}
