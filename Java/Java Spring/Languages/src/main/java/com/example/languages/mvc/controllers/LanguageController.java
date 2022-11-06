package com.example.languages.mvc.controllers;

import com.example.languages.mvc.models.Language;
import com.example.languages.mvc.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages")
    public String allLanguage(Model model, @ModelAttribute("language") Language language) {
        List<Language> Language = languageService.allLanguages();
        model.addAttribute("languages", Language);
        return "index.jsp";
    }

    @PostMapping("/languages")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Language> Language = languageService.allLanguages();
            model.addAttribute("languages", Language);
            return "index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }


    }

    @GetMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }

    @PutMapping("languages/{id}")
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result,
                         @PathVariable("id") Long id) {
//        BindingResult result a container to recaive validation
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    @DeleteMapping("/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    // Request to show specific one details
    @RequestMapping("/language/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "show.jsp";
    }
}
