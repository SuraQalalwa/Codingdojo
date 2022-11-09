package com.loginandregistration.mvc.controllers;

import com.loginandregistration.mvc.models.LoginUser;
import com.loginandregistration.mvc.models.User;
import com.loginandregistration.mvc.servecies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    // Add once service is implemented:
    @Autowired
    private UserService userServ;

    @GetMapping("/")
    public String index(Model model) {

        // Bind empty User and LoginUser objects to the JSP
//        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {

        // TO-DO Later -- call a register method in the service
        // to do some extra validations and create a new user!
        User user = userServ.register(newUser, result);

        if (result.hasErrors()) {
            // Be sure to send in the empty LoginUser before
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user", user.getId());

        // No errors!
        // TO-DO Later: Store their ID from the DB in session,
        // in other words, log them in.

        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {

        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        // No errors!
        // TO-DO Later: Store their ID from the DB in session,
        // in other words, log them in.

        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHome(Model model, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            model.addAttribute("currentUser", currentUser);
            return "home.jsp";

        }
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";

    }
}
