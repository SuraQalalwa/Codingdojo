package com.example.bookapi.mvc.repositories;
import java.util.List;
import com.example.bookapi.mvc.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> { //<class type, type of id in this class>
    List<Book> findAll();
    List<Book> findByDescriptionContaining(String search);
    Long countByLanguageContaining(String search);
    Long deleteByTitleStartingWith(String search);// برجع الاي دي للاشي المحذوف (القصد بlong)



}
