package com.example.jobsearch.repository;

import com.example.jobsearch.model.Position;

import java.util.List;
import java.util.Optional;

public interface PositionRepository {
    void save(Position position);

    Optional<Position> findByid(String title);

    List<Position> findAll();

    List<Position> search(String keyword, String location);
}
