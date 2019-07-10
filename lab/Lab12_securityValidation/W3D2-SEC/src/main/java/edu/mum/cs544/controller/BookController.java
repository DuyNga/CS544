package edu.mum.cs544.controller;

import edu.mum.cs544.service.BookService;
import edu.mum.cs544.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "bookList";
    }

    @GetMapping("/books/add")
    public String viewAdd(@ModelAttribute Book book, Model model) {
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }

    @GetMapping("/books/{id}")
    public String get(@PathVariable(required = false) Integer id, @ModelAttribute Book book, Model model) {
        System.out.println("1");
        model.addAttribute("book", bookService.get(id));
        System.out.println("2");
        model.addAttribute("msg", "Update");
        System.out.println("3");
        return "bookDetail";
    }

    @PostMapping({"/books"})
    public String update(@Valid Book book, BindingResult result) {
        if(result.hasErrors())
            return "bookDetail";
        bookService.update(book); // book.id already set by binding
        return "redirect:/books";
    }

    @PostMapping(value = "/books/delete")
    public String delete(int bookId) {
        bookService.delete(bookId);
        return "redirect:/books";
    }
}
