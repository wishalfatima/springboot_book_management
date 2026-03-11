package com.bookapp.service;

import com.bookapp.model.Genre;
import com.bookapp.repository.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GenreServiceImplTest {

    @InjectMocks
    private GenreServiceImpl genreService;

    @Mock
    private GenreRepository genreRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Genre genre1 = new Genre("Fiction");
        genre1.setId(1L);

        Genre genre2 = new Genre("Non-Fiction");
        genre2.setId(2L);

        List<Genre> genres = Arrays.asList(genre1, genre2);
        when(genreRepository.findAll()).thenReturn(genres);

        List<Genre> result = genreService.findAll();

        assertEquals(2, result.size());
        verify(genreRepository, times(1)).findAll();
    }

    @Test
    public void testFindByIdFound() {
        Genre genre = new Genre("Fantasy");
        genre.setId(1L);

        when(genreRepository.findById(1L)).thenReturn(Optional.of(genre));
        Genre foundGenre = genreService.findById(1L);
        assertNotNull(foundGenre);
        assertEquals("Fantasy", foundGenre.getName());
        verify(genreRepository).findById(1L);
    }

    @Test
    public void testFindByIdNotFound() {
        when(genreRepository.findById(1L)).thenReturn(Optional.empty());
        Genre foundGenre = genreService.findById(1L);
        assertNull(foundGenre);
        verify(genreRepository).findById(1L);
    }

    @Test
    public void testSave() {
        Genre genre = new Genre("Sci-Fi");
        Genre savedGenre = new Genre("Sci-Fi");
        savedGenre.setId(3L);

        when(genreRepository.save(genre)).thenReturn(savedGenre);

        Genre result = genreService.save(genre);

        assertNotNull(result);
        assertEquals(3L, result.getId());
        assertEquals("Sci-Fi", result.getName());
        verify(genreRepository).save(genre);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;

        doNothing().when(genreRepository).deleteById(id);

        genreService.deleteById(id);

        verify(genreRepository, times(1)).deleteById(id);
    }
}
