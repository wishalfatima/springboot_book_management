package com.bookapp.controller;

import com.bookapp.model.Publisher;
import com.bookapp.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    // List all publishers
    @GetMapping
    public String list(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "publishers/list";
    }

    // Show add form
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publishers/form";
    }

    // Save new or edited publisher
    @PostMapping("/save")
    public String savePublisher(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result, Model model) {

        boolean isNewPublisher = (publisher.getId() == null);

        // Validate for duplicates by name + address
        if (isNewPublisher &&
                publisherService.existsByNameAndAddressIgnoreCase(
                        publisher.getName(), publisher.getAddress())) {
            result.rejectValue("name", "error.publisher", "Publisher with this name and address already exists");
        }

        if (result.hasErrors()) {
            return "publishers/form"; // Stay on form if error
        }

        publisherService.save(publisher);
        return "redirect:/publishers";
    }

    // Edit form
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.findById(id);
        if (publisher == null) {
            return "redirect:/publishers";
        }
        model.addAttribute("publisher", publisher);
        return "publishers/form";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        publisherService.delete(id);
        return "redirect:/publishers";
    }
}
