package com.example.bookapi.mvc.controlles;

import com.example.bookapi.mvc.models.Book;
import com.example.bookapi.mvc.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BookController {
// we can use this insted
//    @Autowired
//    BookService bookService;
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String allBook(Model model){
        List<Book> Book = bookService.allBooks();
        model.addAttribute("books", Book);
        return "index.jsp";
    }
    @RequestMapping("/books/{bookid}")
    public String show(Model model,@PathVariable(value = "bookid") Long id){
        Book Book = bookService.findBook(id);
        model.addAttribute("books", Book);
        return "show.jsp";
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
