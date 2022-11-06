package com.example.languages.mvc.repositories;

import com.example.languages.mvc.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findAll();
    List<Language> findByNameContaining(String search);
    Long countByCreatorContaining(String search);
    Long deleteByNameStartingWith(String search);
}
