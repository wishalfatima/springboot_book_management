package com.bookapp.controller;

import com.bookapp.model.Book;
import com.bookapp.model.Genre;
import com.bookapp.model.Publisher;
import com.bookapp.service.BookService;
import com.bookapp.service.GenreService;
import com.bookapp.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private PublisherService publisherService;

    // List all books
    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }


    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        return "book/form";
    }

    // Save new or updated book
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Book book, BindingResult result, Model model) {

        // Re-add lists for dropdowns in case of error
        if (result.hasErrors()) {
            model.addAttribute("genres", genreService.findAll());
            model.addAttribute("publishers", publisherService.findAll());
            return "book/form";
        }

        // Check for duplicate (title + author)
        boolean isNewBook = (book.getId() == null);
        if (isNewBook && bookService.existsByTitleAndAuthorIgnoreCase(book.getTitle(), book.getAuthor())) {
            result.rejectValue("title", "error.book", "A book with this title and author already exists");
            model.addAttribute("genres", genreService.findAll());
            model.addAttribute("publishers", publisherService.findAll());
            return "book/form";
        }

        // Get selected genre & publisher by ID
        Genre genre = genreService.findById(book.getGenre().getId());
        Publisher publisher = publisherService.findById(book.getPublisher().getId());

        if (genre == null || publisher == null) {
            result.rejectValue("genre", "error.book", "Invalid Genre or Publisher selected");
            model.addAttribute("genres", genreService.findAll());
            model.addAttribute("publishers", publisherService.findAll());
            return "book/form";
        }

        book.setGenre(genre);
        book.setPublisher(publisher);

        bookService.save(book);
        return "redirect:/books";
    }


    // Show form to edit a book
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        if (book == null) {
            return "redirect:/books"; // or show error page
        }
        model.addAttribute("book", book);
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        return "book/form";
    }

    // Delete a book
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}
