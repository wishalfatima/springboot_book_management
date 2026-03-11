package com.bookapp.service;

import com.bookapp.model.Publisher;
import java.util.List;

public interface PublisherService {
    List<Publisher> findAll();
    Publisher save(Publisher publisher);
    Publisher findById(Long id);
    void delete(Long id);

    boolean existsByNameAndAddressIgnoreCase(String name, String address);

}
