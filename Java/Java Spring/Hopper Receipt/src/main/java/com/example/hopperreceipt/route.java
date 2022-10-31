package com.example.hopperreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class route {
//    class HomeController {
        @RequestMapping("/")
        public String index(Model model) {
            String firstname = "Grace";
            String lastname = "Hopper";
            String Itemname = "Copper wire";
            double price = 5.25;
            String desc = "Metal strips, also an illustration of nanoseconds.";
            String vendor = "Little Things Corner Store";
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            model.addAttribute("Itemname", Itemname);
            model.addAttribute("price", price);
            model.addAttribute("desc", desc);
            model.addAttribute("vendor", vendor);
            return "index.jsp";
        }

    }
//}
