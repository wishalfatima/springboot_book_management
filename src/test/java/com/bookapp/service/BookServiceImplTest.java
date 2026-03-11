package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testFindAll() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(new Book(), new Book()));
        assertEquals(2, bookService.findAll().size());
    }

    @Test
    void testSave() {
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book, bookService.save(book));
    }

    @Test
    void testFindById() {
        Book book = new Book();
        book.setId(1L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        assertEquals(book, bookService.findById(1L));
    }

    @Test
    void testFindByIdNotFound() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());
        Book result = bookService.findById(99L);
        assertNull(result);
    }


    @Test
    void testDelete() {
        bookService.deleteById(1L);
        verify(bookRepository, times(1)).deleteById(1L);
    }
}
