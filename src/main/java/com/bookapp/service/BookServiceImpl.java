package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepo;

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public boolean existsByTitleAndAuthorIgnoreCase(String title, String author) {
        return bookRepo.findByTitleIgnoreCaseAndAuthorIgnoreCase(title.trim(), author.trim()).isPresent();
    }

}
