package com.bookapp.service;

import com.bookapp.model.Publisher;
import com.bookapp.repository.PublisherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;

class PublisherServiceImplTest {

    @Mock
    private PublisherRepository publisherRepo;

    @InjectMocks
    private PublisherServiceImpl publisherService;

    private Publisher samplePublisher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        samplePublisher = new Publisher();
        samplePublisher.setId(1L);
        samplePublisher.setName("Test Publisher");
        samplePublisher.setAddress("Some Address");
    }

    @Test
    void testSavePublisher() {
        when(publisherRepo.save(samplePublisher)).thenReturn(samplePublisher);
        Publisher result = publisherService.save(samplePublisher);
        assertEquals("Test Publisher", result.getName());
        verify(publisherRepo, times(1)).save(samplePublisher);
    }
    @Test
    void testFindAll() {
        List<Publisher> publishers = List.of(samplePublisher);
        when(publisherRepo.findAll()).thenReturn(publishers);
        List<Publisher> result = publisherService.findAll();
        assertEquals(1, result.size());
        assertEquals(samplePublisher.getName(), result.get(0).getName());
        verify(publisherRepo, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        when(publisherRepo.findById(1L)).thenReturn(Optional.of(samplePublisher));
        Publisher found = publisherService.findById(1L);
        assertNotNull(found);
        assertEquals("Test Publisher", found.getName());
    }

    @Test
    void testFindByIdNotFound() {
        when(publisherRepo.findById(2L)).thenReturn(Optional.empty());
        Publisher found = publisherService.findById(2L);
        assertNull(found);
    }

    @Test
    void testDeletePublisher() {
        doNothing().when(publisherRepo).deleteById(1L);
        publisherService.delete(1L);
        verify(publisherRepo, times(1)).deleteById(1L);
    }
}
