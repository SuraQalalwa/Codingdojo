package com.example.savetravels.mvc.controllers;

import com.example.savetravels.mvc.models.Travel;
import com.example.savetravels.mvc.services.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class TravelController {
    // we can use @Autowired
    private final TravelService travelService;
    public TravelController(TravelService travelService){
        this.travelService = travelService;
    }
    // Get to show all
    @GetMapping("/travels")
    public String allTravel(Model model,@ModelAttribute("travel") Travel travel){
        List<Travel> Travel = travelService.allTravels();
        model.addAttribute("travels", Travel);
        return "index.jsp";
    }
    //Put to edit
    @GetMapping ("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Travel travel = travelService.findTravel(id);
        model.addAttribute("travel", travel);
        return "edit.jsp";
    }
    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result,
                         @PathVariable("id")Long id) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            travelService.updateTravel(travel, id);
            return "redirect:/travels";
        }
    }
    //Post to create new one
    @PostMapping("/travels/{id}")
    public String addNew(@Valid @ModelAttribute("travel") Travel travel, BindingResult result,Model model) {
        if (result.hasErrors()) {
            List<Travel> tra = travelService.allTravels();
            model.addAttribute("travel", tra);
            return "index.jsp";
        }
        else {
            travelService.createTravel(travel);
            return "redirect:/travels";
        }
    }
    // Delete
    @DeleteMapping("/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        travelService.deleteTravel(id);
        return "redirect:/travels";
    }
    // Request to show specific one details
    @RequestMapping("/travel/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Travel travel = travelService.findTravel(id);
        model.addAttribute("travel", travel);
        return "show.jsp";
    }
}




