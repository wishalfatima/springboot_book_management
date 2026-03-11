package com.bookapp.controller;

import com.bookapp.model.Genre;
import com.bookapp.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    // Display list of genres
    @GetMapping
    public String listGenres(Model model) {
        model.addAttribute("genres", genreService.findAll());
        return "genres/list";
    }

    // Show form to create a new genre
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "genres/form";
    }

    // Show form to edit an existing genre
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Genre genre = genreService.findById(id);
        if (genre == null) {
            return "redirect:/genres";
        }
        model.addAttribute("genre", genre);
        return "genres/form";
    }

    // Handle save or update genre
    @PostMapping("/save")
    public String saveGenre(@Valid @ModelAttribute("genre") Genre genre, BindingResult result, Model model) {

        // Check if genre name already exists (case-insensitive)
        boolean isNewGenre = (genre.getId() == null);

        if (isNewGenre && genreService.existsByNameIgnoreCase(genre.getName())) {
            result.rejectValue("name", "error.genre", "Genre with this name already exists");
        }

        if (result.hasErrors()) {
            return "genres/form";
        }

        genreService.save(genre);
        return "redirect:/genres";
    }


    // Delete genre
    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") Long id) {
        genreService.deleteById(id);
        return "redirect:/genres";
    }
}
