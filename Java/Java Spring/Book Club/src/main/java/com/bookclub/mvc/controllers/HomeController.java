package com.bookclub.mvc.controllers;

// .. don't forget to inlcude all your imports! ..

import com.bookclub.mvc.models.Book;
import com.bookclub.mvc.models.LoginUser;
import com.bookclub.mvc.models.User;
import com.bookclub.mvc.sercvises.BookService;
import com.bookclub.mvc.sercvises.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    private UserService userServ;
    private BookService bookService;

    public HomeController(UserService userServ, BookService bookService) {
        this.userServ = userServ;
        this.bookService = bookService;
    }

    /////////////////LogIn & Registeration//////////////////////
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {

        User user = userServ.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user", newUser.getId());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showhome(HttpSession session, Model model, @ModelAttribute("Book") Book book) {
        if ((session.getAttribute("userId") != null)) {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            List<Book> books = bookService.allBook();
            model.addAttribute("books", books);
            model.addAttribute("currentUser", currentUser);
            return "home.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("Book") Book book,Long id, HttpSession session ,Model model) {
        if ((session.getAttribute("userId") != null)) {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            model.addAttribute("currentUser", currentUser);
            return "newbook.jsp";
        }
        else{
            return "redirect:/";
        }
    }
    @PostMapping("/books/new")
    public String addBook(@Valid @ModelAttribute("Book") Book book, Model model, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "/home";
        } else {
            if ((session.getAttribute("userId") != null)) {
                Long userId = (Long) session.getAttribute("userId");
                User currentUser = userServ.findById(userId);
                book.setUser(currentUser);
                bookService.createBook(book);
            }
            return "redirect:/books/new";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/showbook/{bookid}")
    public String showBook(@PathVariable(value = "bookid") Long id, Model model ){
        Book thisbook= bookService.finadById(id);
        model.addAttribute("thisbook", thisbook);
        return "showbook.jsp";
    }
    @GetMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id, HttpSession session) {
        if ((session.getAttribute("userId") == bookService.finadById(id).getUser().getId())) {
            bookService.deleteBook(id);
        }
        return "redirect:/home";
    }
    @GetMapping ("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
        if ((session.getAttribute("userId") == bookService.finadById(id).getUser().getId())) {
            Book book = bookService.finadById(id);
            model.addAttribute("book", book);
            return "editpage.jsp";
        }
        else {
            return "redirect:/showbook/"+id;
        }
    }
    @PostMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result,
                         @PathVariable("id")Long id) {
        if (result.hasErrors()) {
            return "editpage.jsp";
        }
        else {
            bookService.updateBook(book, id);
            return "redirect:/showbook/"+id;
        }
    }

}

