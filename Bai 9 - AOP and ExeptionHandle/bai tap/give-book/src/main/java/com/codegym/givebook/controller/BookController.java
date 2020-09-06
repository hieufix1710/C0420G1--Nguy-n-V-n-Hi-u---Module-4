package com.codegym.givebook.controller;

import com.codegym.givebook.model.Book;
import com.codegym.givebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller

public class BookController {
    private Map<Integer, Book> bookMap = new HashMap<>();
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ModelAndView showListBook() {
        return new ModelAndView("list", "books", this.bookService.getAllBooks());
    }

    @GetMapping("/toRentBook/")
    public ModelAndView viewRentBook(@RequestParam int id) {
        Book book = this.bookService.getBookById(id);
        Random random = new Random();
        int randomNum = random.nextInt(99999 - 10000) + 10000;
        if (book == null) {
            return new ModelAndView("error-page");
        }
        ModelAndView modelAndView = new ModelAndView("RentBook", "book", book);
        modelAndView.addObject("random", randomNum);
        return modelAndView;
    }

    @PostMapping("/rentBook/{random}")
    public ModelAndView rentBook(@ModelAttribute("book") Book book, @PathVariable int random) throws Exception {
        if(bookService.rentBook(book)) {
            bookMap.put(random, book);
            System.out.println(random);
            return new ModelAndView("list","books",bookService. getAllBooks());
        }
        throw new Exception();
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("error");
    }

    
    @GetMapping("/give_book_back")
    public ModelAndView viewGiveBookBack() {
        return new ModelAndView("give-book-back","random", new Integer("0"));
    }

    @PostMapping("/give_book_back")
    public ModelAndView giveBookBack(@RequestParam int random) throws Exception {
        System.out.println(random);
        if(bookMap.containsKey(random)) {
            Book book= bookMap.get(random);
            bookService.giveBookBack(book);
            bookMap.remove(random);
            return new ModelAndView("list","books",bookService.getAllBooks());
        }
        throw new Exception();
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView showErrorGiveBookBack() {
        return new ModelAndView("error-page");
    }
}
