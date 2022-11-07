package com.example.dojoandninjas.mvc.controllers;

import com.example.dojoandninjas.mvc.models.Dojo;
import com.example.dojoandninjas.mvc.models.Ninja;
import com.example.dojoandninjas.mvc.services.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    private final AppService appService;

    public HomeController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/dojos/new")
    public String dojo(@ModelAttribute("dojo") Dojo dojo) {
        return "dojo.jsp";
    }

    @PostMapping("/dojos/new")
    public String newdojo(@Valid @ModelAttribute("dojo") Dojo dojo, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "dojo.jsp";
        } else {
            appService.createDojo(dojo);
            return "redirect:/dojos/new";
        }

    }

    @GetMapping("/ninjas/new")
    public String ninja(@Valid @ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = appService.allDojos();
        model.addAttribute("dojos", dojos);
        return "ninja.jsp";

    }

    @PostMapping("/ninjas/new")
    public String ninja(@Valid @ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
        if (result.hasErrors()) {
            List<Dojo> dojos = appService.allDojos();
            model.addAttribute("dojos", dojos);
            return "ninja.jsp";
        } else {
            appService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
    }

    @RequestMapping("dojo/{id}")
    public String showDojo(@PathVariable("id") Long id,Model model){
        model.addAttribute("dojos", appService.findDojo(id));
        return "showdojo.jsp";


    }
}



