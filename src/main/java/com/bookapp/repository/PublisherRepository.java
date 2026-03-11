package com.bookapp.repository;

import com.bookapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCaseAndAddressIgnoreCase(String name, String address);

}
