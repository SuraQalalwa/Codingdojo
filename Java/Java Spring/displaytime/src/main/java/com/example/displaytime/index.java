package com.example.displaytime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalTime;
import java.time.LocalDate;
import org.springframework.ui.Model;

@Controller
public class index {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    @RequestMapping("/date")
    public String date(Model model) {
        String date = String.valueOf(LocalDate.now());
        model.addAttribute("date",date);
        return "date.jsp";
    }
    @RequestMapping("/time")
    public String time(Model model) {
        String time = String.valueOf(LocalTime.now());
        model.addAttribute("time",time);
        return "time.jsp";
    }
}
