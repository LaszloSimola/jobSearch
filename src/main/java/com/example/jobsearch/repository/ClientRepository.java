package com.example.jobsearch.repository;

import com.example.jobsearch.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    void save(Client client);
    Optional<Client> findByEmail(String email);

    List<Client> findAll();

    boolean existsByApiKey(String apiKey);
}

