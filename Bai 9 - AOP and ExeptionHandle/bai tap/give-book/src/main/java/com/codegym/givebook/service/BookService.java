package com.codegym.givebook.service;

import com.codegym.givebook.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(int id);

    boolean rentBook( Book book);

    void giveBookBack(Book book);
}
