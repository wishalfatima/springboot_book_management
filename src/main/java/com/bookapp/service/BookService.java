package com.bookapp.service;

import com.bookapp.model.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book save(Book book);
    Book findById(Long id);
    void deleteById(Long id);

    boolean existsByTitleAndAuthorIgnoreCase(String title, String author);
}

