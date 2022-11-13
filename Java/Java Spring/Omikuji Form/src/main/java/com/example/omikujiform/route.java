package com.example.omikujiform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class route {
    @GetMapping ("/")
    public String page() {
        return "Omikuji.jsp";
    }

    @PostMapping( "/show")
    public String show(
            @RequestParam(value = "num") String num,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "person") String person,
            @RequestParam(value = "hobby") String hobby,
            @RequestParam(value = "thing") String thing,
            @RequestParam(value = "something") String something, HttpSession session) {

        session.setAttribute("num", num);
        session.setAttribute("city", city);
        session.setAttribute("person", person);
        session.setAttribute("hobby", hobby);
        session.setAttribute("thing", thing);
        session.setAttribute("something", something);
        return "redirect:/show";
    }

    @RequestMapping ("/show")
    public String getData(HttpSession session,Model model){
        model.addAttribute("num", session.getAttribute("num"));
        model.addAttribute("city", session.getAttribute("city"));
        model.addAttribute("person", session.getAttribute("person"));
        model.addAttribute("hobby", session.getAttribute("hobby"));
        model.addAttribute("thing", session.getAttribute("thing"));
        model.addAttribute("something", session.getAttribute("something"));

        return "show.jsp";
    }

}
