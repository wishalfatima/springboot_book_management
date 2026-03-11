package com.bookapp.service;

import com.bookapp.model.Genre;
import java.util.List;

public interface GenreService {
    List<Genre> findAll();
    Genre save(Genre genre);
    Genre findById(Long id);
    void deleteById(Long id);
    Genre getOrCreateGenre(String name);
    boolean existsByNameIgnoreCase(String name);

}
