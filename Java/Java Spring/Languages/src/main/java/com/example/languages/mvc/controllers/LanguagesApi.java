package com.example.languages.mvc.controllers;

import com.example.languages.mvc.models.Language;
import com.example.languages.mvc.services.LanguageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguagesApi {
    private final LanguageService languageService;
    public LanguagesApi(LanguageService language){
        this.languageService = language;
    }
    @RequestMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguages();
    }

    @PostMapping("/api/languages")
    public Language create(@RequestParam(value="name") String name,
                         @RequestParam(value="creator") String creator,
                         @RequestParam(value="version") double version) {
        Language language = new Language(name, creator,version);
        return languageService.createLanguage(language);
    }

}
