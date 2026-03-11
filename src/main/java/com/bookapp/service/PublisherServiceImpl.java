package com.bookapp.service;

import com.bookapp.model.Publisher;
import com.bookapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepo;

    @Override
    public List<Publisher> findAll() {
        return publisherRepo.findAll();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        publisherRepo.deleteById(id);
    }

    @Override
    public boolean existsByNameAndAddressIgnoreCase(String name, String address) {
        return publisherRepository.existsByNameIgnoreCaseAndAddressIgnoreCase(name, address);
    }
    @Autowired
    private PublisherRepository publisherRepository;


}
