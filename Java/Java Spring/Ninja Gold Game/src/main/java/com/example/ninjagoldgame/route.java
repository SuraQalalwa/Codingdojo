package com.example.ninjagoldgame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class route {
    @RequestMapping ("/")
    public String Gold(HttpSession session, Model model) {
//
        if (session.getAttribute("gold") == null) {
            session.setAttribute("color","");
            ArrayList<String> activityList = new ArrayList<String>();
            session.setAttribute("gold", 0);
            session.setAttribute("activities",activityList);
            return "index.jsp";
        }
        else {
            return "index.jsp";
        }
    }
    @RequestMapping  (value="/processMoney", method = RequestMethod.POST)
    public String play(HttpSession session,
                       @RequestParam(value = "whichForm") String activity) {
        Random rNumber = new Random();
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("activities");
        if ("farm".equals(activity)) {
            int x = (int) session.getAttribute("gold");
            int randomNum = rNumber.nextInt(10) + 10;
            int sum = x + randomNum;
            session.setAttribute("gold", sum);
            list.add("You entered farm and earned " + randomNum + " gold.");
        }
        if ("cave".equals(activity)) {
            int x = (int) session.getAttribute("gold");
            int randomNum = rNumber.nextInt(10) + 10;
            int sum = x + randomNum;
            session.setAttribute("gold", sum);
            list.add("You entered cave and earned "+randomNum+" gold.");
        }
        if ("house".equals(activity)) {
            int x = (int) session.getAttribute("gold");
            int randomNum = rNumber.nextInt(10) + 10;
            int sum = x + randomNum;
            session.setAttribute("gold", sum);
            list.add("You entered house and earned "+randomNum+" gold.");
        }
        if ("quest".equals(activity)) {
            int x = (int) session.getAttribute("gold");
            int randomNum = rNumber.nextInt(100) - 50;
            int sum = x + randomNum;
            String color = "";
            if(randomNum > 0){
                session.setAttribute("color", "green");
                session.setAttribute("" +
                        "", sum);
                list.add("You entered quest and earned "+randomNum+" gold.");
            }
            session.setAttribute("gold", sum);
            list.add("You entered quest and lost "+randomNum+" gold.");
        }

            return "redirect:/";
        }

    }

