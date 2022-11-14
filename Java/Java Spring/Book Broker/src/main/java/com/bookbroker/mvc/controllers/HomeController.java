package com.bookbroker.mvc.controllers;

import com.bookbroker.mvc.models.Book;
import com.bookbroker.mvc.models.LoginUser;
import com.bookbroker.mvc.models.User;
import com.bookbroker.mvc.services.BookService;
import com.bookbroker.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userServ;
    @Autowired
    private BookService bookService;
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
            List<Book> notBorrowed = bookService.allNotborrowedBooks();
            model.addAttribute("books", books);
            model.addAttribute("notBorrowed", notBorrowed);
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
            List<Book> books = bookService.allBook();
            model.addAttribute("books", books);
            return "newbook.jsp";
        }
        else{
            return "redirect:/";
        }
    }
    @PostMapping("/books/new")
    public String addBook(@Valid @ModelAttribute("Book") Book book, Model model, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "redirect:/home";
        } else {
            if ((session.getAttribute("userId") != null)) {
                Long userId = (Long) session.getAttribute("userId");
                User currentUser = userServ.findById(userId);
                book.setPostedby(currentUser);
                bookService.createBook(book);
            }
            return "redirect:/books/new";
        }
    }

    @RequestMapping("/return/{bookid}")
    public String returnbook(@PathVariable(value = "bookid") Long bookid, HttpSession session, Model model){
        if (session.getAttribute("userId") != null){
            Long userId= (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            Book thisbook = bookService.finadById(bookid);
            model.addAttribute("thisbook",thisbook);
            currentUser.getBorrowedBooks().remove(thisbook);
            thisbook.setBorrowedby(null);
            userServ.update(currentUser);
            bookService.updateBook(thisbook);

        }
        return "redirect:/home";
    }

    @RequestMapping("/borrow/{bookid}")
    public String borrow(@PathVariable(value = "bookid") Long bookid, HttpSession session, Model model){
        if (session.getAttribute("userId") != null){
            Long userId= (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            Book thisbook = bookService.finadById(bookid);
            model.addAttribute("thisbook",thisbook);
            currentUser.getBorrowedBooks().add(thisbook);
            thisbook.setBorrowedby(currentUser);
            userServ.update(currentUser);
            bookService.updateBook(thisbook);
        }
        return "redirect:/home";

    }
    @GetMapping("/delete/{bookid}")
    public String destroy(@PathVariable("bookid") Long id, HttpSession session) {
        if ((session.getAttribute("userId") != null)) {
            bookService.deleteBook(id);
        }
        return "redirect:/home";
    }
    @GetMapping ("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Book book = bookService.findById(id);
            model.addAttribute("book", book);
            return "editpage.jsp";
        }
        else {
            return "redirect:/home";
        }
    }
    @PostMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book updatebook, BindingResult result,
                         @PathVariable("id")Long id, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            updatebook.setPostedby(currentUser);
//            updatebook.addUserToBook(currentUser);
            bookService.updateBook(updatebook);

        }
        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
