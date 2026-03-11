package com.bookapp.service;

import com.bookapp.model.Genre;
import com.bookapp.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepo;

    @Override
    public List<Genre> findAll() {
        return genreRepo.findAll();
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepo.save(genre);
    }

    @Override
    public Genre findById(Long id) {
        return genreRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        genreRepo.deleteById(id);
    }

    public Genre getOrCreateGenre(String name) {
        return genreRepo.findByNameIgnoreCase(name.trim())
                .orElseGet(() -> genreRepo.save(new Genre(name.trim())));
    }
    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return genreRepo.findByNameIgnoreCase(name.trim()).isPresent();
    }



}
