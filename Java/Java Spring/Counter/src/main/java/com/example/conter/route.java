package com.example.conter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class route {
    @RequestMapping("/")
    public String counter(HttpSession session, Model model){
        if (session.getAttribute("count") == null) {
            session.setAttribute("count",0);
        }
        else {
            Integer x = (Integer) session.getAttribute("count"); //to read it
            x++; //to do something with it// increment the count by 1 using getAttribute and setAttribute
            session.setAttribute("count",x);
        }
        model.addAttribute("cnt", session.getAttribute("count"));
        return "server.jsp";

    }

    @RequestMapping("/counter")
    public String server(Model model,HttpSession session){
        model.addAttribute("cnt", session.getAttribute("count"));

        return "count.jsp";

    }

}
