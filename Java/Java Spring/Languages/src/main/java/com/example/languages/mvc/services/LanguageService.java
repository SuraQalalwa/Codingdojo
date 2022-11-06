package com.example.languages.mvc.services;

import com.example.languages.mvc.models.Language;
import com.example.languages.mvc.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LanguageService {
           // adding the book repository as a dependency
        private final LanguageRepository languageRepository; //related to dependency injection
        public LanguageService(LanguageRepository languageRepository) { //here we inject the service dependency in repository dependency
            this.languageRepository = languageRepository;
        }
        public List<Language> allLanguages() {
            return languageRepository.findAll();
        }
        public Language createLanguage(Language b) {
            return languageRepository.save(b);
        }
        public Language findLanguage(Long id) {
            Optional<Language> optionalLanguage = languageRepository.findById(id); // optional since it may not find nothing and to do not have error
            if(optionalLanguage.isPresent()) {
                return optionalLanguage.get();
            } else {
                return null;
            }
        }
        public Language updateLanguage(Long id, String name, String creator, double version) {
            Optional<Language> language1 = languageRepository.findById(id);
            if(language1.isPresent()) {
                Language updateLanguage= language1.get();
                updateLanguage.setName(name);
                updateLanguage.setCreator(creator);
                updateLanguage.setVersion(version);

                return languageRepository.save(updateLanguage);
            }
            else {
                return null;
            }
        }
        public void deleteLanguage(Long id) {
            languageRepository.deleteById(id);
        }
        public Language updateLanguage(Language language) {
            return languageRepository.save(language) ;
        }
}
