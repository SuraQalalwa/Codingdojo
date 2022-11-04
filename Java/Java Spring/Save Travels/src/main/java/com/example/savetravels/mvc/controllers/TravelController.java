package com.example.savetravels.mvc.controllers;

import com.example.savetravels.mvc.models.Travel;
import com.example.savetravels.mvc.services.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class TravelController {
    // we can use this insted
//    @Autowired
    private final TravelService travelService;
    public TravelController(TravelService travelService){
        this.travelService = travelService;
    }

    @GetMapping("/travels")
    public String allTravel(Model model){
        List<Travel> Travel = travelService.allTravels();
        model.addAttribute("travels", Travel);
        return "index.jsp";
    }
    @RequestMapping("/travels/{travelid}")
    public String show(Model model,@PathVariable(value = "travelid") Long id){
        Travel Travel = travelService.findTravel(id);
        model.addAttribute("travels", Travel);
        return "show.jsp";
    }
    @PostMapping("/addtravel")
    public String addTravel(Model model,
                            @PathVariable("id") Long id,
                            @RequestParam(value="expense") String expense,
                            @RequestParam(value="vendor") String vendor,
                            @RequestParam(value="amount") double amount){

        Travel travel= new Travel(expense,vendor,amount);
        travelService.createTravel(travel);
//        model.addAttribute("travel", travel);
        return "redirect:/travels/new";
    }

    @GetMapping("/travels/new")
    public String newTravel(@ModelAttribute("travel") Travel travel) {
        return "index.jsp";
    }

//    @Autowired
//    BookService bookService;
//    @GetMapping("/books")
//    public String index(){
//        return "index.jsp";
//    }
//    @GetMapping("/api/books")
//    public List<Book> test(){
////        System.out.println(id);
////        Book Book = bookService.findBook(id);
////        System.out.println(Book);
//        return bookService.allBooks();
//    }
}
