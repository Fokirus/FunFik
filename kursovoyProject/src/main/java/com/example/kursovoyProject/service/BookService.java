package com.example.kursovoyProject.service;

import com.example.kursovoyProject.entity.Book;
import com.example.kursovoyProject.entity.User;

import java.util.List;

public interface BookService {
    public Book creatBook(Book book);
    public Book findBookById(Long id);
    public Book updateBook(Book book);
    public void deleteBook(Long id);
    public List<Book> findAllBook();
}
